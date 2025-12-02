package com.example.soldadura.controller;

import com.example.soldadura.model.Proyecto;
import com.example.soldadura.service.ProyectoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {

    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping
    public List<Proyecto> obtenerProyectos() {
        return proyectoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerProyectoPorId(@PathVariable Long id) {
        return proyectoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearProyecto(@RequestBody Proyecto proyecto) {

        if (proyecto == null) {
            return ResponseEntity.badRequest().body("No se recibió ningún proyecto");
        }
        if (proyecto.getCliente() == null) {
            return ResponseEntity.badRequest().body("El cliente es obligatorio");
        }
        if (proyecto.getServicio() == null) {
            return ResponseEntity.badRequest().body("El servicio es obligatorio");
        }

        Proyecto nuevoProyecto = proyectoService.crearProyecto(proyecto);
        return ResponseEntity.ok(nuevoProyecto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {

        if (proyecto.getCliente() == null) {
            return ResponseEntity.badRequest().body("El cliente es obligatorio");
        }
        if (proyecto.getServicio() == null) {
            return ResponseEntity.badRequest().body("El servicio es obligatorio");
        }

        return ResponseEntity.ok(proyectoService.actualizarProyecto(id, proyecto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return ResponseEntity.ok().build();
    }
}
