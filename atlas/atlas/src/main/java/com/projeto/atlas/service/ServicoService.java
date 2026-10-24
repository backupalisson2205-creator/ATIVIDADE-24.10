
package com.projeto.atlas.service;

import com.projeto.atlas.entity.ServicoEntity;
import com.projeto.atlas.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository) {
        this.repository = repository;
    }

    public List<ServicoEntity> listarTodos() {
        return repository.findAll();
    }

    public ServicoEntity salvarServico(ServicoEntity servico) {
        if (repository.findByNome(servico.getNome()).isPresent()) {
            throw new IllegalArgumentException("Servico já cadastrado.");
        }

        return repository.save(servico);
    }

    public ServicoEntity atualizarServico(Long id, ServicoEntity servico) {
        ServicoEntity servicoExistente = repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pets não encontrado."));

        servicoExistente.setNome(servico.getNome());
        servicoExistente.setDescricao(servico.getDescricao());

        return repository.save(servicoExistente);
    }


    public void excluirServico(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("servico não encontrado.");
        }

        repository.deleteById(id);
    }


}
