package com.example.soldadura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyecto proyecto;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private double cantidad;

    @Column(nullable = false)
    private String unidades;

    private Double costo_unitario;

    private Double costo_total;

    public Material() {
    }

    public Material(Long id, Proyecto proyecto, String nombre, double cantidad, String unidades, Double costo_unitario, Double costo_total) {
        this.id = id;
        this.proyecto = proyecto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidades = unidades;
        this.costo_unitario = costo_unitario;
        this.costo_total = costo_total;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public Double getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(Double costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    public Double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(Double costo_total) {
        this.costo_total = costo_total;
    }
}
