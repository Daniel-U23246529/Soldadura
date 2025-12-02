package com.example.soldadura.service;

import com.example.soldadura.model.Material;
import com.example.soldadura.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<Material> listarTodos() {
        return materialRepository.findAll();
    }

    public Optional<Material> buscarPorId(Long id) {
        return materialRepository.findById(Math.toIntExact(id));
    }

    public Material crearMaterial(Material material) {
        if (material.getCosto_unitario() != null) {
            material.setCosto_total(material.getCantidad() * material.getCosto_unitario());
        } else if (material.getCosto_total() == null) {
            material.setCosto_total(0.0);
        }
        return materialRepository.save(material);
    }

    public Material actualizarMaterial(Long id, Material material) {
        material.setId(id);
        if (material.getCosto_unitario() != null) {
            material.setCosto_total(material.getCantidad() * material.getCosto_unitario());
        } else if (material.getCosto_total() == null) {
            material.setCosto_total(0.0);
        }
        return materialRepository.save(material);
    }

    public void eliminarMaterial(Long id) {
        materialRepository.deleteById(Math.toIntExact(id));
    }
}
