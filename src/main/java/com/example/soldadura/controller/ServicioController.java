package com.example.soldadura.controller;

import com.example.soldadura.model.Servicio;
import com.example.soldadura.service.ServicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio")
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public List<Servicio> obtenerServicios() {
        return servicioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> obtenerServicioPorId(@PathVariable Long id) {
        return servicioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearServicio(@RequestBody Servicio servicio) {
        if (servicio.getNombre() == null || servicio.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre es obligatorio");
        }
        if (servicio.getDescripcion() == null || servicio.getDescripcion().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La descripción es obligatoria");
        }

        Servicio nuevoServicio = servicioService.crearServicio(servicio);
        return ResponseEntity.ok(nuevoServicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarServicio(@PathVariable Long id, @RequestBody Servicio servicio) {
        if (servicio.getNombre() == null || servicio.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre es obligatorio");
        }
        if (servicio.getDescripcion() == null || servicio.getDescripcion().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La descripción es obligatoria");
        }

        return ResponseEntity.ok(servicioService.actualizarServicio(id,servicio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarServicio(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
        return ResponseEntity.ok().build();
    }
}
