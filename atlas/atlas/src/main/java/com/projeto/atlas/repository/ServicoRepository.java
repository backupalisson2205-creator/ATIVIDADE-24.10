
package com.projeto.atlas.repository;

import com.projeto.atlas.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicoRepository
        extends JpaRepository<ServicoEntity, Long> {

    Optional<ServicoEntity> findByNome(String nome);
}
