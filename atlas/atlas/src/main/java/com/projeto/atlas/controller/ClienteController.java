
package com.projeto.atlas.controller;

import com.projeto.atlas.entity.ClienteEntity;
import com.projeto.atlas.service.ClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClienteEntity> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(
            @RequestBody ClienteEntity cliente) {

        service.salvarCliente(cliente);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of(
                        "mensagem", "Cliente cadastrado com sucesso."
                ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody ClienteEntity cliente) {

        service.atualizarCliente(id, cliente);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "mensagem", "Cliente atualizado com sucesso."
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(
            @PathVariable Long id) {

        service.excluirCliente(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "mensagem", "Cliente excluído com sucesso."
                ));
    }
}
