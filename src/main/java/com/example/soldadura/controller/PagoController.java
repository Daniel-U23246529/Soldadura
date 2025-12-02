package com.example.soldadura.controller;

import com.example.soldadura.model.Pago;
import com.example.soldadura.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pago")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public List<Pago> obtenerPagos() {
        return pagoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtenerPagoPorId(@PathVariable Long id) {
        return pagoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearPago(@RequestBody Pago pago) {
        if (pago == null) {
            return ResponseEntity.badRequest().body("No se recibió ningún pago");
        }
        if (pago.getFactura() == null) {
            return ResponseEntity.badRequest().body("La factura es obligatoria");
        }
        if (pago.getMonto_pagado() <= 0) {
            return ResponseEntity.badRequest().body("El monto pagado debe ser mayor a cero");
        }
        if (pago.getMetodo_pago() == null || pago.getMetodo_pago().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El método de pago es obligatorio");
        }

        Pago nuevoPago = pagoService.crearPago(pago);
        return ResponseEntity.ok(nuevoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPago(@PathVariable Long id, @RequestBody Pago pago) {
        if (pago == null) {
            return ResponseEntity.badRequest().body("No se recibió ningún pago");
        }
        if (pago.getFactura() == null) {
            return ResponseEntity.badRequest().body("La factura es obligatoria");
        }
        if (pago.getMonto_pagado() <= 0) {
            return ResponseEntity.badRequest().body("El monto pagado debe ser mayor a cero");
        }
        if (pago.getMetodo_pago() == null || pago.getMetodo_pago().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El método de pago es obligatorio");
        }

        return ResponseEntity.ok(pagoService.actualizarPago(id, pago));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPago(@PathVariable Long id) {
        pagoService.eliminarPago(id);
        return ResponseEntity.ok().build();
    }
}
