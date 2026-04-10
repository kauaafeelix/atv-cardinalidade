package com.weg.centroweg.cardinalidade.app.dto.projeto;

import jakarta.validation.constraints.NotBlank;

public record ProjetoRequestDto(
        @NotBlank(message = "O nome do projeto é obrigatório")
        String nome
) {
}
