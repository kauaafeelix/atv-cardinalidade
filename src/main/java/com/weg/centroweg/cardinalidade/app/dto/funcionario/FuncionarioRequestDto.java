package com.weg.centroweg.cardinalidade.app.dto.funcionario;

import java.util.List;

public record FuncionarioRequestDto(
        String nome,
        Long idAssento,
        List<Long> idProjetos
) {
}
