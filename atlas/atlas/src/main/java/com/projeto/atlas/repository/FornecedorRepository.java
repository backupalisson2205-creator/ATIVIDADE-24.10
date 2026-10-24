
package com.projeto.atlas.repository;

import com.projeto.atlas.entity.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FornecedorRepository
        extends JpaRepository<FornecedorEntity, Long> {

    Optional<FornecedorEntity> findByCnpj(String cnpj);
}
