package com.projeto.atlas.controller;

import com.projeto.atlas.entity.ServicoEntity;
import com.projeto.atlas.service.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    private final ServicoService service;

    public ServicoController(ServicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServicoEntity> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(
            @RequestBody ServicoEntity servico) {

        service.salvarServico(servico);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Serviço cadastrado com sucesso."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody ServicoEntity servico) {

        service.atualizarServico(id, servico);

        return ResponseEntity
                .ok(Map.of("mensagem", "Serviço atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(
            @PathVariable Long id) {

        service.excluirServico(id);

        return ResponseEntity
                .ok(Map.of("mensagem", "Serviço excluído com sucesso."));
    }
}