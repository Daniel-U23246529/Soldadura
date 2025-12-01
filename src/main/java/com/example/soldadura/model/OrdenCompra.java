package com.example.soldadura.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "OrdenCompra")
public class OrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @Column(nullable = false)
    private String numero_orden;

    @Column(nullable = false)
    private Date fecha_emision;


    @Column(nullable = false)
    private double monto_aprobado;


    public OrdenCompra() {
    }
}
