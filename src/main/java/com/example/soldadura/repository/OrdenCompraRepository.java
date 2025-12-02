package com.example.soldadura.repository;

import com.example.soldadura.model.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraRepository  extends JpaRepository<OrdenCompra, Integer> {
    OrdenCompra findTopByOrderByIdDesc();
}
