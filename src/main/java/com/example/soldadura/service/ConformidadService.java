package com.example.soldadura.service;

import com.example.soldadura.model.Conformidad;
import com.example.soldadura.repository.ConformidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConformidadService {

    private final ConformidadRepository conformidadRepository;

    public ConformidadService(ConformidadRepository conformidadRepository) {
        this.conformidadRepository = conformidadRepository;
    }

    public List<Conformidad> listarTodas() {
        return conformidadRepository.findAll();
    }

    public Optional<Conformidad> buscarPorId(Long id) {
        return conformidadRepository.findById(Math.toIntExact(id));
    }

    public Conformidad crearConformidad(Conformidad conformidad) {
        return conformidadRepository.save(conformidad);
    }

    public Conformidad actualizarConformidad(Long id, Conformidad conformidad) {
        conformidad.setId(id);
        return conformidadRepository.save(conformidad);
    }

    public void eliminarConformidad(Long id) {
        conformidadRepository.deleteById(Math.toIntExact(id));
    }
}
