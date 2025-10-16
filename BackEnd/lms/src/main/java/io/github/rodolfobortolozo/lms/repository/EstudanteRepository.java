package io.github.rodolfobortolozo.lms.repository;

import io.github.rodolfobortolozo.arquitetura.repository.BaseRepository;
import io.github.rodolfobortolozo.lms.model.Estudante;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends BaseRepository<Estudante, Long> {

    boolean existsByEmail(String email);
}
