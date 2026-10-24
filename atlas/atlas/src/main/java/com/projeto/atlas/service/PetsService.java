package com.projeto.atlas.service;

import com.projeto.atlas.entity.PetsEntity;
import com.projeto.atlas.repository.Petsrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsService {

    private final Petsrepository repository;

    public PetsService(Petsrepository repository) {
        this.repository = repository;
    }

    public List<PetsEntity> listarTodos() {
        return repository.findAll();
    }

    public PetsEntity salvarPets(PetsEntity pets) {
        if (repository.findByNome(pets.getNome()).isPresent()) {
            throw new IllegalArgumentException("Pest já cadastrado.");
        }

        return repository.save(pets);
    }

    public PetsEntity atualizarPets(Long id, PetsEntity pets) {
        PetsEntity pestsExistente = repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pets não encontrado."));

        pestsExistente.setNome(pets.getNome());
        pestsExistente.setEspecie(pets.getEspecie());

        return repository.save(pestsExistente);
    }


    public void excluirPets(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("pets não encontrado.");
        }

        repository.deleteById(id);
    }


}