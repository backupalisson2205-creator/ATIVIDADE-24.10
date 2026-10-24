
package com.projeto.atlas.repository;

import com.projeto.atlas.entity.PetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Petsrepository
        extends JpaRepository<PetsEntity, Long> {

    Optional<PetsEntity> findByNome(String nome);
}
