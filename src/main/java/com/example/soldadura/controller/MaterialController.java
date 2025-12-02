package com.example.soldadura.controller;

import com.example.soldadura.model.Material;
import com.example.soldadura.service.MaterialService;
import com.example.soldadura.model.Proyecto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/material")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public List<Material> obtenerMateriales() {
        return materialService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> obtenerMaterialPorId(@PathVariable Long id) {
        return materialService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearMaterial(@RequestBody Material material) {

        if (material == null) {
            return ResponseEntity.badRequest().body("No se recibió ningún material");
        }
        if (material.getProyecto() == null) {
            return ResponseEntity.badRequest().body("El proyecto es obligatorio");
        }
        if (material.getNombre() == null || material.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre es obligatorio");
        }
        if (material.getCantidad() <= 0) {
            return ResponseEntity.badRequest().body("La cantidad debe ser mayor a 0");
        }
        if (material.getUnidades() == null || material.getUnidades().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Las unidades son obligatorias");
        }

        // Calcular costo_total si existe costo_unitario
        if (material.getCosto_unitario() != null) {
            material.setCosto_total(material.getCantidad() * material.getCosto_unitario());
        } else if (material.getCosto_total() == null) {
            material.setCosto_total(0.0);
        }

        Material nuevoMaterial = materialService.crearMaterial(material);
        return ResponseEntity.ok(nuevoMaterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarMaterial(@PathVariable Long id, @RequestBody Material material) {

        if (material == null) {
            return ResponseEntity.badRequest().body("No se recibió ningún material");
        }
        if (material.getProyecto() == null) {
            return ResponseEntity.badRequest().body("El proyecto es obligatorio");
        }
        if (material.getNombre() == null || material.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre es obligatorio");
        }
        if (material.getCantidad() <= 0) {
            return ResponseEntity.badRequest().body("La cantidad debe ser mayor a 0");
        }
        if (material.getUnidades() == null || material.getUnidades().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Las unidades son obligatorias");
        }

        if (material.getCosto_unitario() != null) {
            material.setCosto_total(material.getCantidad() * material.getCosto_unitario());
        } else if (material.getCosto_total() == null) {
            material.setCosto_total(0.0);
        }

        return ResponseEntity.ok(materialService.actualizarMaterial(id, material));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMaterial(@PathVariable Long id) {
        materialService.eliminarMaterial(id);
        return ResponseEntity.ok().build();
    }
}
