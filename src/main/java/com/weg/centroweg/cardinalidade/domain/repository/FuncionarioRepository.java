package com.weg.centroweg.cardinalidade.domain.repository;

import com.weg.centroweg.cardinalidade.domain.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
