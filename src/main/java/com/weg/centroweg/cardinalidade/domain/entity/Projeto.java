package com.weg.centroweg.cardinalidade.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.models.annotations.internal.SQLJoinTableRestrictionAnnotation;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "projetos")
    private List<Funcionario> funcionarios;

    @Column(nullable = false)
    private String nome;

    public Projeto(String nome) {
        this.nome = nome;
    }
}
