package com.example.soldadura.controller;

import com.example.soldadura.model.Presupuesto;
import com.example.soldadura.service.PresupuestoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/presupuesto")
public class PresupuestoController {

    private final PresupuestoService presupuestoService;

    public PresupuestoController(PresupuestoService presupuestoService) {
        this.presupuestoService = presupuestoService;
    }

    @GetMapping
    public List<Presupuesto> obtenerPresupuestos() {
        return presupuestoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Presupuesto> obtenerPresupuestoPorId(@PathVariable Long id) {
        return presupuestoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearPresupuesto(@RequestBody Presupuesto presupuesto) {
        if (presupuesto == null) {
            return ResponseEntity.badRequest().body("No se recibió ningún presupuesto");
        }
        if (presupuesto.getProyecto() == null) {
            return ResponseEntity.badRequest().body("El proyecto es obligatorio");
        }
        if (presupuesto.getCosto_manoObra() < 0) {
            return ResponseEntity.badRequest().body("El costo de mano de obra no puede ser negativo");
        }
        if (presupuesto.getCosto_gastosAdministrativos() < 0) {
            return ResponseEntity.badRequest().body("El costo de gastos administrativos no puede ser negativo");
        }

        Presupuesto nuevoPresupuesto = presupuestoService.crearPresupuesto(presupuesto);
        return ResponseEntity.ok(nuevoPresupuesto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPresupuesto(@PathVariable Long id, @RequestBody Presupuesto presupuesto) {
        if (presupuesto == null) {
            return ResponseEntity.badRequest().body("No se recibió ningún presupuesto");
        }
        if (presupuesto.getProyecto() == null) {
            return ResponseEntity.badRequest().body("El proyecto es obligatorio");
        }
        if (presupuesto.getCosto_manoObra() < 0) {
            return ResponseEntity.badRequest().body("El costo de mano de obra no puede ser negativo");
        }
        if (presupuesto.getCosto_gastosAdministrativos() < 0) {
            return ResponseEntity.badRequest().body("El costo de gastos administrativos no puede ser negativo");
        }

        return ResponseEntity.ok(presupuestoService.actualizarPresupuesto(id, presupuesto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPresupuesto(@PathVariable Long id) {
        presupuestoService.eliminarPresupuesto(id);
        return ResponseEntity.ok().build();
    }
}
