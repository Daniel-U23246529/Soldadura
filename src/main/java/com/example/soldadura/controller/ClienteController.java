package com.example.soldadura.controller;


import com.example.soldadura.model.Cliente;
import com.example.soldadura.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> obtenerClientes(){
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id){
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente){

        if (cliente.getNombre() ==null || cliente.getNombre().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo del nombre es obligatorio");
        }
        if (cliente.getRuc() ==null || cliente.getRuc().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo ruc es obligatorio");
        }

        if (cliente.getDireccion() ==null || cliente.getDireccion().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo direccion es obligatorio");
        }

        if (cliente.getTelefono() ==null || cliente.getTelefono().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo telefono es obligatorio");
        }
        Cliente nuevoCliente = clienteService.crearCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public  ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        try {
            Cliente clienteActualizado = clienteService.actualizarCliente(id, cliente);
            return ResponseEntity.ok(clienteActualizado);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> EliminarCliente(@PathVariable Long id){
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
