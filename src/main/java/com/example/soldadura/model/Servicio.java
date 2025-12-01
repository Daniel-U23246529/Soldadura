package com.example.soldadura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;


    public Servicio() {
    }
}
