package com.weg.centroweg.cardinalidade.app.service;

import com.weg.centroweg.cardinalidade.app.dto.assento.AssentoRequestDto;
import com.weg.centroweg.cardinalidade.app.dto.assento.AssentoResponseDto;
import com.weg.centroweg.cardinalidade.app.mapper.AssentoMapper;
import com.weg.centroweg.cardinalidade.domain.entity.Assento;
import com.weg.centroweg.cardinalidade.domain.exception.EntitadeNaoExiste;
import com.weg.centroweg.cardinalidade.infra.repository.AssentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AssentoService {

    private final AssentoRepository repository;
    private final AssentoMapper mapper;


    public AssentoResponseDto criarAssento (AssentoRequestDto request){

        Assento assento = mapper.toEntity(request);

        repository.save(assento);

        return mapper.toDto(assento);
    }

    public List<AssentoResponseDto> mostrarAssentos (){

        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public AssentoResponseDto buscarPorId(Long id){

        Assento assento = repository.findById(id)
                .orElseThrow(() -> new EntitadeNaoExiste("O assento não existe."));

        return mapper.toDto(assento);
    }

    public AssentoResponseDto atualizarAssento (Long id, AssentoRequestDto request){

        Assento assento = repository.findById(id)
                .orElseThrow(() -> new EntitadeNaoExiste("O assento não existe."));

        assento.setCodigo(request.codigo());

        repository.save(assento);

        return mapper.toDto(assento);

    }

    public void deletarAssento (Long id){
        Assento assento = repository.findById(id)
                .orElseThrow(() -> new EntitadeNaoExiste("O assento não existe."));

        repository.deleteById(id);
    }
}
