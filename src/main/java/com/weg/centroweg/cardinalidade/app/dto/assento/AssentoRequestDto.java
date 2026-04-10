package com.weg.centroweg.cardinalidade.app.dto.assento;

import jakarta.validation.constraints.NotBlank;

public record AssentoRequestDto(
        @NotBlank(message = "O código do assento é obrigatório")
        String codigo
) {
}
