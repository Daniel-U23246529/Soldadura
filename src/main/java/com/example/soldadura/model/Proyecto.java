package com.example.soldadura.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @OneToOne(mappedBy = "proyecto", cascade = CascadeType.ALL)
    @JsonIgnore
    private OrdenCompra ordenCompra;

    @OneToOne(mappedBy = "proyecto", cascade = CascadeType.ALL)
    @JsonIgnore
    private Conformidad conformidad;

    @OneToOne(mappedBy = "proyecto", cascade = CascadeType.ALL)
    @JsonIgnore
    private Presupuesto presupuesto;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Factura> facturas;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Material> materiales = new ArrayList<>();;


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(nullable = false)
    private Date fechaCreado;

    @Column(nullable = false)
    private boolean estado;

    public Proyecto() {

    }
    //Constructor con parámetros
    public Proyecto(Long id, Cliente cliente, Servicio servicio, List<Material> materiales, OrdenCompra ordenCompra, Conformidad conformidad, Presupuesto presupuesto, List<Factura> facturas, Date fechaCreado, boolean estado) {
        this.id = id;
        this.cliente = cliente;
        this.servicio = servicio;
        this.materiales = materiales;
        this.ordenCompra = ordenCompra;
        this.conformidad = conformidad;
        this.presupuesto = presupuesto;
        this.facturas = facturas;
        this.fechaCreado = fechaCreado;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Conformidad getConformidad() {
        return conformidad;
    }

    public void setConformidad(Conformidad conformidad) {
        this.conformidad = conformidad;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Date getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
