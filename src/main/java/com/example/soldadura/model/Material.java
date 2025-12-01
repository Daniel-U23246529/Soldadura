package com.example.soldadura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyecto proyecto;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private double cantidad;

    @Column(nullable = false)
    private String unidades;

    @Column(nullable = false)
    private double costo_unitario;
    public Material() {
    }
}
