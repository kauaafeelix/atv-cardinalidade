package com.weg.centroweg.cardinalidade.infra.controller;

import com.weg.centroweg.cardinalidade.app.dto.funcionario.FuncionarioRequestDto;
import com.weg.centroweg.cardinalidade.app.dto.funcionario.FuncionarioResponseDto;
import com.weg.centroweg.cardinalidade.app.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> save (@Valid @RequestBody FuncionarioRequestDto request){
        FuncionarioResponseDto response = funcionarioService.criarFuncionario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> findAll(){
        List<FuncionarioResponseDto> response = funcionarioService.listarFuncionarios();
        return ResponseEntity.ok(response);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<FuncionarioResponseDto> findById (@PathVariable Long id) {
        FuncionarioResponseDto response = funcionarioService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("nome/{nome}")
    public ResponseEntity<FuncionarioResponseDto> findByNome (@PathVariable String nome) {
        FuncionarioResponseDto response = funcionarioService.buscarPorNome(nome);
        return ResponseEntity.ok(response);
    }

    @GetMapping("assentos/{codigoAssento}")
    public ResponseEntity<FuncionarioResponseDto> findByAssento (@PathVariable String codigoAssento) {
       FuncionarioResponseDto response = funcionarioService.buscarPorCodigoAssento(codigoAssento);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> update (@PathVariable Long id, @Valid @RequestBody FuncionarioRequestDto request) {
        FuncionarioResponseDto response = funcionarioService.atualizarFuncionario(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }

}
