package com.example.soldadura.service;

import com.example.soldadura.model.Pago;
import com.example.soldadura.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public List<Pago> listarTodos() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> buscarPorId(Long id) {
        return pagoRepository.findById(Math.toIntExact(id));
    }

    public Pago crearPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago actualizarPago(Long id, Pago pago) {
        pago.setId(id);
        return pagoRepository.save(pago);
    }

    public void eliminarPago(Long id) {
        pagoRepository.deleteById(Math.toIntExact(id));
    }
}
