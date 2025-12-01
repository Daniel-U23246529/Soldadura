package com.example.soldadura.repository;

import com.example.soldadura.model.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresupuestoRepository  extends JpaRepository<Presupuesto, Integer> {
}
