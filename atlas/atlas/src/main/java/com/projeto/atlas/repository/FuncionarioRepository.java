
package com.projeto.atlas.repository;

import com.projeto.atlas.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository
        extends JpaRepository<FuncionarioEntity, Long> {

    Optional<FuncionarioEntity> findByEmail(String email);
}
