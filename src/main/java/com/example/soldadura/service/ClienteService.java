package com.example.soldadura.service;

import com.example.soldadura.model.Cliente;
import com.example.soldadura.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //pa listar
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    //pa buscar por id
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    //
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
