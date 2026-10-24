package com.projeto.atlas.controller;

import com.projeto.atlas.entity.FuncionarioEntity;
import com.projeto.atlas.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioEntity> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<?, ?>> salvar(
            @RequestBody FuncionarioEntity funcionario) {

        service.salvarFuncionario(funcionario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionario cadastrado com sucesso."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<?, ?>> atualizar(
            @PathVariable Long id,
            @RequestBody FuncionarioEntity funcionario) {

        service.atualizarFuncionario(id, funcionario);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionario atualizado com sucesso."));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?, ?>> excluir(@PathVariable Long id) {

        service.excluirFuncionario(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionario excluido com sucesso."));
    }
}
