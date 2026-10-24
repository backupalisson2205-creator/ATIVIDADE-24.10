
package com.projeto.atlas.service;

import com.projeto.atlas.entity.FornecedorEntity;
import com.projeto.atlas.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    private final FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public List<FornecedorEntity> listarTodos() {
        return repository.findAll();
    }

    public FornecedorEntity salvarFornecedor(FornecedorEntity fornecedor) {
        if (repository.findByCnpj(fornecedor.getCnpj()).isPresent()) {
            throw new IllegalArgumentException("fornecedor já cadastrado.");
        }

        return repository.save(fornecedor);
    }

    public FornecedorEntity atualizarFornecedor(Long id, FornecedorEntity fornecedor) {
        FornecedorEntity fornecedorExistente = repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("fornecedor não encontrado."));

        fornecedorExistente.setRazaoSocial(fornecedor.getRazaoSocial());
        fornecedorExistente.setCnpj(fornecedor.getCnpj());

        return repository.save(fornecedorExistente);
    }


    public void excluirFornecedor(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Fornecedor não encontrado.");
        }

        repository.deleteById(id);
    }


}
