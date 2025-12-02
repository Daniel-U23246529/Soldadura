package com.example.soldadura.service;

import com.example.soldadura.model.OrdenCompra;
import com.example.soldadura.repository.OrdenCompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;

    public OrdenCompraService(OrdenCompraRepository ordenCompraRepository) {
        this.ordenCompraRepository = ordenCompraRepository;
    }

    public List<OrdenCompra> listarTodas() {
        return ordenCompraRepository.findAll();
    }

    public Optional<OrdenCompra> buscarPorId(Long id) {
        return ordenCompraRepository.findById(Math.toIntExact(id));
    }

    public OrdenCompra crearOrdenCompra(OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    public OrdenCompra actualizarOrdenCompra(Long id, OrdenCompra ordenCompra) {
        ordenCompra.setId(id);
        return ordenCompraRepository.save(ordenCompra);
    }

    public void eliminarOrdenCompra(Long id) {
        ordenCompraRepository.deleteById(Math.toIntExact(id));
    }
}
