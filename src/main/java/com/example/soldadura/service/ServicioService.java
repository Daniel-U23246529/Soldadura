package com.example.soldadura.service;

import com.example.soldadura.model.Servicio;
import com.example.soldadura.repository.ServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> listarTodos() {
        return servicioRepository.findAll();
    }

    public Optional<Servicio> buscarPorId(Long id) {
        return servicioRepository.findById(Math.toIntExact(id));
    }

    public Servicio crearServicio(Servicio servicio) {

        return servicioRepository.save(servicio);
    }

    public Servicio actualizarServicio(Long id, Servicio servicio) {
        servicio.setId(id);
        return servicioRepository.save(servicio);
    }

    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(Math.toIntExact(id));
    }
}
