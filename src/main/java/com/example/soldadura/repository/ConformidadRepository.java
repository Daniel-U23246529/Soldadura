package com.example.soldadura.repository;

import com.example.soldadura.model.Conformidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConformidadRepository  extends JpaRepository<Conformidad, Integer> {
}
