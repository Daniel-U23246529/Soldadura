package com.example.soldadura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Presupuesto")
public class Presupuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyecto proyecto;

    @Column(nullable = false)
    private double costo_materiales;

    @Column(nullable = false)
    private double costo_manoObra;

    @Column(nullable = false)
    private double costo_gastosAdministtrativos;


    public Presupuesto() {
    }
}
