package com.projeto.atlas.controller;

import com.projeto.atlas.entity.PetsEntity;
import com.projeto.atlas.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private PetsService service;

    @GetMapping
    public List<PetsEntity> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<?, ?>> salvar(
            @RequestBody PetsEntity pets) {

        service.salvarPets(pets);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Pets cadastrado com sucesso."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<?, ?>> atualizar(
            @PathVariable Long id,
            @RequestBody PetsEntity pets) {

        service.atualizarPets(id, pets);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pets atualizado com sucesso."));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?, ?>> excluir(@PathVariable Long id) {

        service.excluirPets(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pets excluido com sucesso."));
    }
}
