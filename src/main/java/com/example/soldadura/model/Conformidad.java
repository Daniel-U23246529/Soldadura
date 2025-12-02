package com.example.soldadura.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private Proyecto proyecto;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String supervisor;


    private String comentarios;

    public Conformidad() {
    }

    //Constructor con parámetros
    public Conformidad(Long id, Proyecto proyecto, Date fecha, String supervisor, String comentarios) {
        this.id = id;
        this.proyecto = proyecto;
        this.fecha = fecha;
        this.supervisor = supervisor;
        this.comentarios = comentarios;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
