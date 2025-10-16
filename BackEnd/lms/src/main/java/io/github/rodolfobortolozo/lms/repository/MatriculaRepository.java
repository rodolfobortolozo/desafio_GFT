package io.github.rodolfobortolozo.lms.repository;

import io.github.rodolfobortolozo.arquitetura.repository.BaseRepository;
import io.github.rodolfobortolozo.lms.model.Curso;
import io.github.rodolfobortolozo.lms.model.Estudante;
import io.github.rodolfobortolozo.lms.model.Matricula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends BaseRepository<Matricula, Long> {


    boolean existsByEstudanteAndCursoAndStatusEquals(Estudante estudante, Curso curso,String status);

    @Query("SELECT count(m) FROM Matricula m WHERE m.status = ?1 and m.estudante = ?2  ")
    int qtdCursosAtivo(String status, Estudante estudante);

}
