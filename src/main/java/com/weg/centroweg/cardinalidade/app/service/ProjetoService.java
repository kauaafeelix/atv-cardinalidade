package com.weg.centroweg.cardinalidade.app.service;

import com.weg.centroweg.cardinalidade.app.dto.projeto.ProjetoRequestDto;
import com.weg.centroweg.cardinalidade.app.dto.projeto.ProjetoResponseDto;
import com.weg.centroweg.cardinalidade.app.mapper.ProjetoMapper;
import com.weg.centroweg.cardinalidade.domain.entity.Projeto;
import com.weg.centroweg.cardinalidade.domain.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjetoService {

    private final ProjetoRepository repository;
    private final ProjetoMapper mapper;


    public ProjetoResponseDto criarProjeto (ProjetoRequestDto request){

        Projeto projeto = mapper.toEntity(request);

        repository.save(projeto);

        return mapper.toDto(projeto);
    }

    public List<ProjetoResponseDto> listarTodos (){

        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public ProjetoResponseDto buscarPorId (Long id){

        Projeto projeto = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O projeto não existe."));

        return mapper.toDto(projeto);
    }

    public ProjetoResponseDto atualizar (Long id, ProjetoRequestDto request){

        Projeto projeto = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O projeto não existe."));

        projeto.setNome(request.nome());

        repository.save(projeto);

        return mapper.toDto(projeto);
    }

    public void deletar (Long id){
        Projeto projeto = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O projeto não existe."));

        repository.deleteById(id);
    }
}
