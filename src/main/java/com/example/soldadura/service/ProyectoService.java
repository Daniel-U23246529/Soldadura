package com.example.soldadura.service;

import com.example.soldadura.model.Proyecto;
import com.example.soldadura.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public List<Proyecto> listarTodos() {
        return proyectoRepository.findAll();
    }

    public Optional<Proyecto> buscarPorId(Long id) {
        return proyectoRepository.findById(Math.toIntExact(id));
    }

    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public Proyecto actualizarProyecto(Long id, Proyecto proyecto) {
        proyecto.setId(id);
        return proyectoRepository.save(proyecto);
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(Math.toIntExact(id));
    }
}
