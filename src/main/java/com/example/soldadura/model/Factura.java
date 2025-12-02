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

    //Constructor con parámetros
    public Factura(Long id, Proyecto proyecto, String numero_factura, String descripcion, double monto, Date fecha_emision, String estado_sunat) {
        this.id = id;
        this.proyecto = proyecto;
        this.numero_factura = numero_factura;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha_emision = fecha_emision;
        this.estado_sunat = estado_sunat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getEstado_sunat() {
        return estado_sunat;
    }

    public void setEstado_sunat(String estado_sunat) {
        this.estado_sunat = estado_sunat;
    }
}
