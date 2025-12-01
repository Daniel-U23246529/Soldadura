package com.example.soldadura.repository;

import com.example.soldadura.model.cliente;
import com.example.soldadura.model.pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository  extends JpaRepository<pago, Integer> {
}
