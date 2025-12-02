package com.example.soldadura.controller;


import com.example.soldadura.model.Factura;
import com.example.soldadura.service.FacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> obtenerFacturas() {
        return facturaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long id){
        return facturaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearFactura(@RequestBody Factura factura){

        if(factura.getDescripcion() == null || factura.getDescripcion().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo descrpcion es obligatorio");
        }

        if(factura.getNumero_factura() == null || factura.getNumero_factura().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo del numero de la factura es obligatorio");
        }

        Factura f = facturaService.crearFactura(factura);
        return  new ResponseEntity<>(f, HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable Long id, @RequestBody Factura factura) {
        try {

            Factura facturaActualizada = facturaService.actualizarFactura(id, factura);
            return ResponseEntity.ok(facturaActualizada);
        } catch (RuntimeException e) {

            if (e.getMessage().contains("no encontrada")) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Long id) {
        facturaService.eliminarFactura(id);

        return ResponseEntity.noContent().build();

    }
}
