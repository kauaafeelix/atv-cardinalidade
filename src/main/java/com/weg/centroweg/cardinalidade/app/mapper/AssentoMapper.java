package com.weg.centroweg.cardinalidade.app.mapper;

import com.weg.centroweg.cardinalidade.app.dto.assento.AssentoRequestDto;
import com.weg.centroweg.cardinalidade.app.dto.assento.AssentoResponseDto;
import com.weg.centroweg.cardinalidade.domain.entity.Assento;
import org.springframework.stereotype.Component;

@Component
public class AssentoMapper {

    public Assento toEntity (AssentoRequestDto request){

        return new Assento(
                request.codigo()
        );
    }

    public AssentoResponseDto toDto (Assento assento){

        return new AssentoResponseDto(
                assento.getId(),
                assento.getCodigo()
        );
    }
}
