package com.weg.centroweg.cardinalidade.infra.controller;

import com.weg.centroweg.cardinalidade.app.dto.assento.AssentoRequestDto;
import com.weg.centroweg.cardinalidade.app.dto.assento.AssentoResponseDto;
import com.weg.centroweg.cardinalidade.app.service.AssentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/assentos")
public class AssentoController {

    private final AssentoService assentoService;

    @PostMapping
    public ResponseEntity<AssentoResponseDto> save (@Valid @RequestBody AssentoRequestDto request){
        AssentoResponseDto response = assentoService.criarAssento(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AssentoResponseDto>> findAll(){
        List<AssentoResponseDto> response = assentoService.mostrarAssentos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssentoResponseDto> findById (@PathVariable Long id){
        AssentoResponseDto response = assentoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AssentoResponseDto> update (@PathVariable Long id, @Valid @RequestBody AssentoRequestDto request) {
        AssentoResponseDto response = assentoService.atualizarAssento(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        assentoService.deletarAssento(id);
        return ResponseEntity.noContent().build();
    }
}
