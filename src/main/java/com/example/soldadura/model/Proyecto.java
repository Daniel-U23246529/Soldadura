package com.example.soldadura.model;

import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private List<Material> materiales;

    @OneToOne(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private OrdenCompra ordenCompra;

    @OneToOne(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private Conformidad conformidad;

    @OneToOne(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private Presupuesto presupuesto;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private List<Factura> facturas;

    @Column(nullable = false)
    private Date fechaCreado;

    @Column(nullable = false)
    private boolean estado;

    public Proyecto() {}
}
