package com.weg.centroweg.cardinalidade.app.dto.funcionario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FuncionarioRequestDto(
        @NotBlank(message = "O nome do funcionário é obrigatório")
        String nome,
        @NotNull(message = "O ID do assento é obrigatório")
        Long idAssento,
        @NotNull(message = "A lista de IDs de projetos é obrigatória")
        List<Long> idProjetos
) {
}
