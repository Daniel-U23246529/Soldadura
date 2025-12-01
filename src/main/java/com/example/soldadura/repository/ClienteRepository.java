package com.example.soldadura.repository;


import com.example.soldadura.model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<cliente, Integer> {
}
