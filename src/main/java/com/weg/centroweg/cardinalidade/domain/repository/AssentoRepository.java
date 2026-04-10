package com.weg.centroweg.cardinalidade.domain.repository;

import com.weg.centroweg.cardinalidade.domain.entity.Assento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssentoRepository extends JpaRepository<Assento, Long> {
}
