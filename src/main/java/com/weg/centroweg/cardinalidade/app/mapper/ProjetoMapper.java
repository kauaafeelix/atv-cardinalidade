package com.weg.centroweg.cardinalidade.app.mapper;

import com.weg.centroweg.cardinalidade.app.dto.projeto.ProjetoRequestDto;
import com.weg.centroweg.cardinalidade.app.dto.projeto.ProjetoResponseDto;
import com.weg.centroweg.cardinalidade.domain.entity.Projeto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjetoMapper {

    public Projeto toEntity (ProjetoRequestDto request){

        return new Projeto(
                request.nome()
        );
    }

    public ProjetoResponseDto toDto (Projeto projeto){

        return new ProjetoResponseDto(
                projeto.getId(),
                projeto.getNome()
        );
    }

    public List<ProjetoResponseDto> toDtoList(List<Projeto> projetos) {
        return projetos.stream()
                .map(this::toDto)
                .toList();
    }
}
