package com.example.soldadura.service;

import com.example.soldadura.model.Cliente;
import com.example.soldadura.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteService;

    public ClienteService(ClienteRepository clienteService) {
        this.clienteService = clienteService;
    }

    public List<Cliente> listarTodas() {
        return clienteService.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteService.findById(Math.toIntExact(id));
    }

    public Cliente crearCombinado(Cliente combinado) {
        return clienteService.save(combinado);
    }

    public Cliente actualizarCombinado(Long id, Cliente combinado) {
        combinado.setId(id);
        return clienteService.save(combinado);
    }

    public void eliminarCombinado(Long id) {
        clienteService.deleteById(Math.toIntExact(id));
    }


}
