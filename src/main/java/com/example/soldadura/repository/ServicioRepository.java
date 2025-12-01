package com.example.soldadura.repository;

import com.example.soldadura.model.cliente;
import com.example.soldadura.model.servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository  extends JpaRepository<servicio, Integer> {
}
