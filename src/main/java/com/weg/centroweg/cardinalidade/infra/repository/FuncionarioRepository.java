package com.weg.centroweg.cardinalidade.infra.repository;

import com.weg.centroweg.cardinalidade.domain.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByNome(String nome);

    Optional<Funcionario> findByAssento_Codigo(String assentoCodigo);
}
