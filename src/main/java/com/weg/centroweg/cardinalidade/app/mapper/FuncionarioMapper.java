package com.weg.centroweg.cardinalidade.app.mapper;

import com.weg.centroweg.cardinalidade.app.dto.funcionario.FuncionarioRequestDto;
import com.weg.centroweg.cardinalidade.app.dto.funcionario.FuncionarioResponseDto;
import com.weg.centroweg.cardinalidade.domain.entity.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FuncionarioMapper {

    private final AssentoMapper assentoMapper;
    private final ProjetoMapper projetoMapper;

    public Funcionario toEntity(FuncionarioRequestDto request){

        return new Funcionario(
            request.nome()
        );
    }

    public FuncionarioResponseDto toDto (Funcionario funcionario){

        return new FuncionarioResponseDto(
                funcionario.getId(),
                funcionario.getNome(),
                assentoMapper.toDto(funcionario.getAssento()),
                projetoMapper.toDtoList(funcionario.getProjetos())
        );
    }
}
