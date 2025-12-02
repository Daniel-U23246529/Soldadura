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

    public double getMonto_aprobado() {
        return monto_aprobado;
    }

    public void setMonto_aprobado(double monto_aprobado) {
        this.monto_aprobado = monto_aprobado;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(String numero_orden) {
        this.numero_orden = numero_orden;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
