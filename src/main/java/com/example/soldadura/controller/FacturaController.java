package com.example.soldadura.controller;

import com.example.soldadura.model.Factura;
import com.example.soldadura.service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factura")
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
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long id) {
        return facturaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearFactura(@RequestBody Factura factura) {
        if (factura.getProyecto() == null) {
            return ResponseEntity.badRequest().body("El proyecto es obligatorio");
        }
        if (factura.getMonto() <= 0) {
            return ResponseEntity.badRequest().body("El monto debe ser mayor a cero");
        }
        if (factura.getEstado_sunat() == null || factura.getEstado_sunat().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El estado SUNAT es obligatorio");
        }

        Factura nuevaFactura = facturaService.crearFactura(factura);
        return ResponseEntity.ok(nuevaFactura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarFactura(@PathVariable Long id, @RequestBody Factura factura) {
        if (factura.getProyecto() == null) {
            return ResponseEntity.badRequest().body("El proyecto es obligatorio");
        }
        if (factura.getMonto() <= 0) {
            return ResponseEntity.badRequest().body("El monto debe ser mayor a cero");
        }
        if (factura.getEstado_sunat() == null || factura.getEstado_sunat().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El estado SUNAT es obligatorio");
        }

        Factura facturaActualizada = facturaService.actualizarFactura(id, factura);
        return ResponseEntity.ok(facturaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarFactura(@PathVariable Long id) {
        facturaService.eliminarFactura(id);
        return ResponseEntity.ok().build();
    }
}
