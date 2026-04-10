package com.weg.centroweg.cardinalidade.infra.controller;

import com.weg.centroweg.cardinalidade.app.dto.projeto.ProjetoRequestDto;
import com.weg.centroweg.cardinalidade.app.dto.projeto.ProjetoResponseDto;
import com.weg.centroweg.cardinalidade.app.service.ProjetoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoResponseDto> save (@Valid @RequestBody ProjetoRequestDto request){
        ProjetoResponseDto response = projetoService.criarProjeto(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponseDto>> findAll(){
        List<ProjetoResponseDto> response = projetoService.listarTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoResponseDto> findById (@PathVariable Long id){
        ProjetoResponseDto response = projetoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProjetoResponseDto> update (@PathVariable Long id, @Valid @RequestBody ProjetoRequestDto request) {
        ProjetoResponseDto response = projetoService.atualizar(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        projetoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
