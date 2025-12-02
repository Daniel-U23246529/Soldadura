package com.example.soldadura.controller;

import com.example.soldadura.model.OrdenCompra;
import com.example.soldadura.service.OrdenCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orden-compra")
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;

    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

    @GetMapping
    public List<OrdenCompra> obtenerOrdenes() {
        return ordenCompraService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompra> obtenerOrdenPorId(@PathVariable Long id) {
        return ordenCompraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearOrden(@RequestBody OrdenCompra ordenCompra) {
        if (ordenCompra.getProyecto() == null) {
            return ResponseEntity.badRequest().body("El proyecto es obligatorio");
        }
        if (ordenCompra.getPresupuesto() == null) {
            return ResponseEntity.badRequest().body("El presupuesto es obligatorio");
        }
        if (ordenCompra.getMonto_aprobado() <= 0) {
            return ResponseEntity.badRequest().body("El monto aprobado debe ser mayor a cero");
        }

        OrdenCompra nuevaOrden = ordenCompraService.crearOrdenCompra(ordenCompra);
        return ResponseEntity.ok(nuevaOrden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarOrden(@PathVariable Long id, @RequestBody OrdenCompra ordenCompra) {
        if (ordenCompra.getPresupuesto() == null) {
            return ResponseEntity.badRequest().body("El presupuesto es obligatorio");
        }
        if (ordenCompra.getMonto_aprobado() <= 0) {
            return ResponseEntity.badRequest().body("El monto aprobado debe ser mayor a cero");
        }

        return ResponseEntity.ok(ordenCompraService.actualizarOrdenCompra(id, ordenCompra));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOrden(@PathVariable Long id) {
        ordenCompraService.eliminarOrdenCompra(id);
        return ResponseEntity.ok().build();
    }
}
