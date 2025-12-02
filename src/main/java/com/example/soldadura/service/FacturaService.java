package com.example.soldadura.service;

import com.example.soldadura.model.Factura;
import com.example.soldadura.repository.FacturaRepository;
import com.example.soldadura.util.Codigo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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
        Factura ultima = facturaRepository.findTopByOrderByIdDesc();
        int siguienteId;
        if (ultima == null) {
            siguienteId = 1;
        } else {
            siguienteId = Math.toIntExact(ultima.getId() + 1);
        }

        factura.setNumero_factura(new Codigo().generarCodigo("FTC", siguienteId));
        factura.setFecha_emision(new Date());
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
