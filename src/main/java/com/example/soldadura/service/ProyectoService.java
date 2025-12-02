package com.example.soldadura.service;

import com.example.soldadura.model.Proyecto;
import com.example.soldadura.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        proyecto.setFechaCreado(new Date());
        return proyectoRepository.save(proyecto);
    }

    public Proyecto actualizarProyecto(Long id, Proyecto proyectoActualizado) {
        Proyecto proyectoExistente = proyectoRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        proyectoExistente.setCliente(proyectoActualizado.getCliente());
        proyectoExistente.setServicio(proyectoActualizado.getServicio());
        proyectoExistente.setEstado(proyectoActualizado.isEstado());
        proyectoExistente.setFechaCreado(proyectoExistente.getFechaCreado());

        if (proyectoActualizado.getMateriales() != null) {
            proyectoActualizado.getMateriales().forEach(m -> m.setProyecto(proyectoExistente));
            proyectoExistente.setMateriales(proyectoActualizado.getMateriales());
        }

        return proyectoRepository.save(proyectoExistente);
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(Math.toIntExact(id));
    }
}
