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

    //Constructor con parámetros
    public Presupuesto(Long id, Proyecto proyecto, double costo_materiales, double costo_manoObra, double costo_gastosAdministtrativos) {
        this.id = id;
        this.proyecto = proyecto;
        this.costo_materiales = costo_materiales;
        this.costo_manoObra = costo_manoObra;
        this.costo_gastosAdministtrativos = costo_gastosAdministtrativos;
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

    public double getCosto_materiales() {
        return costo_materiales;
    }

    public void setCosto_materiales(double costo_materiales) {
        this.costo_materiales = costo_materiales;
    }

    public double getCosto_manoObra() {
        return costo_manoObra;
    }

    public void setCosto_manoObra(double costo_manoObra) {
        this.costo_manoObra = costo_manoObra;
    }

    public double getCosto_gastosAdministtrativos() {
        return costo_gastosAdministtrativos;
    }

    public void setCosto_gastosAdministtrativos(double costo_gastosAdministtrativos) {
        this.costo_gastosAdministtrativos = costo_gastosAdministtrativos;
    }
}
