package com.example.soldadura.repository;

import com.example.soldadura.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository  extends JpaRepository<Factura, Integer> {
}
