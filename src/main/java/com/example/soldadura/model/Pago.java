package com.example.soldadura.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "factura_id",nullable = false)
    @JsonBackReference
    private Factura factura;

    private Date fecha_pago;

    private double monto_pagado;

    private String metodo_pago;

    public Pago() {
    }

    //Constructor con parámetros
    public Pago(Long id, Factura factura, Date fecha_pago, double monto_pagado, String metodo_pago) {
        this.id = id;
        this.factura = factura;
        this.fecha_pago = fecha_pago;
        this.monto_pagado = monto_pagado;
        this.metodo_pago = metodo_pago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getMonto_pagado() {
        return monto_pagado;
    }

    public void setMonto_pagado(double monto_pagado) {
        this.monto_pagado = monto_pagado;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
}
