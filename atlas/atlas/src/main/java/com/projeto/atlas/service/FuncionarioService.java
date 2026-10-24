
package com.projeto.atlas.service;

import com.projeto.atlas.entity.FuncionarioEntity;
import com.projeto.atlas.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<FuncionarioEntity> listarTodos() {
        return repository.findAll();
    }

    public FuncionarioEntity salvarFuncionario(FuncionarioEntity funcionario) {
        if (repository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("funcionario já cadastrado.");
        }

        return repository.save(funcionario);
    }

    public FuncionarioEntity atualizarFuncionario(Long id, FuncionarioEntity funcionario) {
        FuncionarioEntity funcionarioExistente = repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Funcionario não encontrado."));

        funcionarioExistente.setNome(funcionario.getNome());
        funcionarioExistente.setEmail(funcionario.getEmail());

        return repository.save(funcionarioExistente);
    }


    public void excluirFuncionario(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionario não encontrado.");
        }

        repository.deleteById(id);
    }


}
