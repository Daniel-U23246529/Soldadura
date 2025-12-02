package com.example.soldadura.service;

import com.example.soldadura.model.Factura;
import com.example.soldadura.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> listarTodas() {
        return facturaRepository.findAll();
    }

    public Optional<Factura> buscarPorId(Long id) {
        return facturaRepository.findById(Math.toIntExact(id));
    }

    public Factura crearFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura actualizarFactura(Long id, Factura factura) {
        factura.setId(id);
        return facturaRepository.save(factura);
    }

    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(Math.toIntExact(id));
    }
}
