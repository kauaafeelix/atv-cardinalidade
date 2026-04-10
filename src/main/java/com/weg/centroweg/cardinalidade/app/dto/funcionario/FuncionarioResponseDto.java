package com.weg.centroweg.cardinalidade.app.dto.funcionario;

import com.weg.centroweg.cardinalidade.app.dto.assento.AssentoResponseDto;
import com.weg.centroweg.cardinalidade.app.dto.projeto.ProjetoResponseDto;
import com.weg.centroweg.cardinalidade.domain.entity.Projeto;

import java.util.List;

public record FuncionarioResponseDto(
        Long id,
        String nome,
        AssentoResponseDto assento,
        List<ProjetoResponseDto> projetos
) {
}
