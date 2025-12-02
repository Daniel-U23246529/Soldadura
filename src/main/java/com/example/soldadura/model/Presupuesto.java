package com.example.soldadura.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Presupuesto")
public class Presupuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    @JsonBackReference
    private Proyecto proyecto;

    @Column(nullable = false)
    private double costo_manoObra;

    @Column(nullable = false)
    private double costo_gastosAdministrativos;

    public Presupuesto() {
    }

    public Presupuesto(Long id, Proyecto proyecto, double costo_manoObra, double costo_gastosAdministrativos) {
        this.id = id;
        this.proyecto = proyecto;
        this.costo_manoObra = costo_manoObra;
        this.costo_gastosAdministrativos = costo_gastosAdministrativos;
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

    public double getCosto_manoObra() {
        return costo_manoObra;
    }

    public void setCosto_manoObra(double costo_manoObra) {
        this.costo_manoObra = costo_manoObra;
    }

    public double getCosto_gastosAdministrativos() {
        return costo_gastosAdministrativos;
    }

    public void setCosto_gastosAdministrativos(double costo_gastosAdministrativos) {
        this.costo_gastosAdministrativos = costo_gastosAdministrativos;
    }
}
