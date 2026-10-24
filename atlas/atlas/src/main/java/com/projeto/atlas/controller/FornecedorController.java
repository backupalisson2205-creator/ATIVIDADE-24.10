package com.projeto.atlas.controller;

import com.projeto.atlas.entity.FornecedorEntity;
import com.projeto.atlas.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public List<FornecedorEntity> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<?, ?>> salvar(
            @RequestBody FornecedorEntity funcionario) {

        service.salvarFornecedor(funcionario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionario cadastrado com sucesso."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<?, ?>> atualizar(
            @PathVariable Long id,
            @RequestBody FornecedorEntity funcionario) {

        service.atualizarFornecedor(id, funcionario);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionario atualizado com sucesso."));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?, ?>> excluir(@PathVariable Long id) {

        service.excluirFornecedor(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionario excluido com sucesso."));
    }
}
