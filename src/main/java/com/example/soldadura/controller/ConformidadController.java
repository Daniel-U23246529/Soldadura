package com.example.soldadura.controller;

import com.example.soldadura.model.Conformidad;
import com.example.soldadura.service.ConformidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conformidad")
public class ConformidadController {

    private final ConformidadService conformidadService;

    public ConformidadController(ConformidadService conformidadService) {
        this.conformidadService = conformidadService;
    }

    @GetMapping
    public List<Conformidad> obtenerConformidades() {
        return conformidadService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conformidad> obtenerConformidadPorId(@PathVariable Long id) {
        return conformidadService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearConformidad(@RequestBody Conformidad conformidad) {
        if (conformidad.getProyecto() == null) {
            return ResponseEntity.badRequest().body("El proyecto es obligatorio");
        }
        if (conformidad.getSupervisor() == null || conformidad.getSupervisor().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El supervisor es obligatorio");
        }

        Conformidad nuevaConformidad = conformidadService.crearConformidad(conformidad);
        return ResponseEntity.ok(nuevaConformidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarConformidad(@PathVariable Long id, @RequestBody Conformidad conformidad) {
        if (conformidad.getProyecto() == null) {
            return ResponseEntity.badRequest().body("El proyecto es obligatorio");
        }
        if (conformidad.getSupervisor() == null || conformidad.getSupervisor().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El supervisor es obligatorio");
        }

        Conformidad conformidadActualizada = conformidadService.actualizarConformidad(id, conformidad);
        return ResponseEntity.ok(conformidadActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarConformidad(@PathVariable Long id) {
        conformidadService.eliminarConformidad(id);
        return ResponseEntity.ok().build();
    }
}
