package com.example.soldadura.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proyecto_id",nullable = false)
    private Proyecto proyecto;

    @Column(nullable = false)
    private String numero_factura;

    private String descripcion;

    @Column(nullable = false)
    private double monto;

    @Column(nullable = false)
    private Date fecha_emision;

    @Column(nullable = false)
    private String estado_sunat;

    public Factura() {
    }
}
