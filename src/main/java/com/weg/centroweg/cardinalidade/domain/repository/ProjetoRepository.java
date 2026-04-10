package com.weg.centroweg.cardinalidade.domain.repository;

import com.weg.centroweg.cardinalidade.domain.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
