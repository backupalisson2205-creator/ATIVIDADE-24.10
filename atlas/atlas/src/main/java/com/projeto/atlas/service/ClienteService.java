
package com.projeto.atlas.service;

import com.projeto.atlas.entity.ClienteEntity;
import com.projeto.atlas.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<ClienteEntity> listarTodos() {
        return repository.findAll();
    }

    public ClienteEntity salvarCliente(ClienteEntity cliente) {
        if (repository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }

        return repository.save(cliente);
    }

    public ClienteEntity atualizarCliente(Long id, ClienteEntity cliente) {
        ClienteEntity clienteExistente = repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Cliente não encontrado."));

        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEmail(cliente.getEmail());

        return repository.save(clienteExistente);
    }


    public void excluirCliente(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        repository.deleteById(id);
    }


}
