package io.github.rodolfobortolozo.lms.repository;

import io.github.rodolfobortolozo.arquitetura.repository.BaseRepository;
import io.github.rodolfobortolozo.lms.model.Estudante;
import io.github.rodolfobortolozo.lms.model.Parametro;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroRepository extends BaseRepository<Parametro, Long> {
}
