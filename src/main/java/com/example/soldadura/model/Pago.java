package com.example.soldadura.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "factura_id",nullable = false)
    private Factura factura;

    @Column(nullable = false)
    private Date fecha_pago;

    private double monto_pagado;

    private String metodo_pago;




    public Pago() {
    }
}
