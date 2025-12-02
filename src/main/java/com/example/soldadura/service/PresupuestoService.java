package com.example.soldadura.service;

import com.example.soldadura.model.Presupuesto;
import com.example.soldadura.repository.PresupuestoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresupuestoService {

    private final PresupuestoRepository presupuestoRepository;

    public PresupuestoService(PresupuestoRepository presupuestoRepository) {
        this.presupuestoRepository = presupuestoRepository;
    }

    public List<Presupuesto> listarTodos() {
        return presupuestoRepository.findAll();
    }

    public Optional<Presupuesto> buscarPorId(Long id) {
        return presupuestoRepository.findById(Math.toIntExact(id));
    }

    public Presupuesto crearPresupuesto(Presupuesto presupuesto) {
        return presupuestoRepository.save(presupuesto);
    }

    public Presupuesto actualizarPresupuesto(Long id, Presupuesto presupuesto) {
        presupuesto.setId(id);
        return presupuestoRepository.save(presupuesto);
    }

    public void eliminarPresupuesto(Long id) {
        presupuestoRepository.deleteById(Math.toIntExact(id));
    }
}
