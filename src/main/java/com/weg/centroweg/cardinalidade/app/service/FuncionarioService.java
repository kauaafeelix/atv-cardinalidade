package com.weg.centroweg.cardinalidade.app.service;

import com.weg.centroweg.cardinalidade.app.dto.funcionario.FuncionarioRequestDto;
import com.weg.centroweg.cardinalidade.app.dto.funcionario.FuncionarioResponseDto;
import com.weg.centroweg.cardinalidade.app.mapper.FuncionarioMapper;
import com.weg.centroweg.cardinalidade.domain.entity.Assento;
import com.weg.centroweg.cardinalidade.domain.entity.Funcionario;
import com.weg.centroweg.cardinalidade.domain.entity.Projeto;
import com.weg.centroweg.cardinalidade.domain.exception.EntitadeNaoExiste;
import com.weg.centroweg.cardinalidade.infra.repository.AssentoRepository;
import com.weg.centroweg.cardinalidade.infra.repository.FuncionarioRepository;
import com.weg.centroweg.cardinalidade.infra.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;
    private final ProjetoRepository projetoRepository;
    private final AssentoRepository assentoRepository;


    public FuncionarioResponseDto criarFuncionario (FuncionarioRequestDto request){

        Assento assento = assentoRepository.findById(request.idAssento())
                .orElseThrow(() -> new EntitadeNaoExiste("O assento não existe."));

        List<Projeto> projetos = projetoRepository.findAllById(request.idProjetos());

        Funcionario funcionario = funcionarioMapper.toEntity(request);

        funcionario.setAssento(assento);
        funcionario.setProjetos(projetos);

        funcionarioRepository.save(funcionario);

        return funcionarioMapper.toDto(funcionario);
    }

    public List<FuncionarioResponseDto> listarFuncionarios (){

        return funcionarioRepository.findAll()
                .stream()
                .map(funcionarioMapper::toDto)
                .toList();
    }

    public FuncionarioResponseDto buscarPorId (Long id){

        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntitadeNaoExiste("O funcionário não existe."));

        return funcionarioMapper.toDto(funcionario);
    }

    public FuncionarioResponseDto buscarPorNome (String nome){

        Funcionario funcionario = funcionarioRepository.findByNome(nome)
                .orElseThrow(() -> new EntitadeNaoExiste("O funcionário não existe."));

        return funcionarioMapper.toDto(funcionario);
    }

    public FuncionarioResponseDto buscarPorCodigoAssento (String codigo){

        Funcionario funcionario = funcionarioRepository.findByAssento_Codigo(codigo)
                .orElseThrow(() -> new EntitadeNaoExiste("O funcionário não existe."));

        return funcionarioMapper.toDto(funcionario);
    }

    public FuncionarioResponseDto atualizarFuncionario (Long id, FuncionarioRequestDto request){

        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntitadeNaoExiste("O funcionário não existe."));

        Assento assento = assentoRepository.findById(request.idAssento())
                .orElseThrow(() -> new EntitadeNaoExiste("O assento não existe."));

        List<Projeto> projetos = projetoRepository.findAllById(request.idProjetos());

        funcionario.setNome(request.nome());
        funcionario.setAssento(assento);
        funcionario.setProjetos(projetos);

        funcionarioRepository.save(funcionario);

        return funcionarioMapper.toDto(funcionario);
    }

    public void deletarFuncionario (Long id){
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntitadeNaoExiste("O funcionário não existe."));

        funcionarioRepository.deleteById(id);
    }
}
