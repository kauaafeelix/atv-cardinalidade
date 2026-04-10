package com.weg.centroweg.cardinalidade.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigo;

    @OneToOne(mappedBy = "assento")
    private Funcionario funcionario;

    public Assento(String codigo) {
        this.codigo = codigo;
    }
}
