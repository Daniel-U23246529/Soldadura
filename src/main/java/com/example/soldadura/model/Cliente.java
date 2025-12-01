package com.example.soldadura.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String ruc;

    private String direccion;

    private String telefono;

    private String email;

    public Cliente() {
    }


}
