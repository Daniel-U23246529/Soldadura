package com.example.soldadura.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Conformidad")
public class Conformidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "proyecto_id",nullable = false)
    private Proyecto proyecto;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String supervisor;


    private String comentarios;

    public Conformidad() {
    }


}
