package io.github.rodolfobortolozo.lms.repository;

import io.github.rodolfobortolozo.arquitetura.repository.BaseRepository;
import io.github.rodolfobortolozo.lms.model.Curso;
import io.github.rodolfobortolozo.lms.model.dto.CursoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends BaseRepository<Curso, Long> {

    boolean existsByNome(String nome);

    @Query("""
       SELECT new io.github.rodolfobortolozo.lms.model.dto.CursoDTO(
           c.id,
           c.nome,
           c.descricao,
           CASE WHEN m.id IS NOT NULL THEN true ELSE false END
       )
       FROM Curso c
       LEFT JOIN Matricula m 
            ON m.curso = c AND m.estudante.id = :idEstudante AND m.status = 'ATIVA'
       """)
    List<CursoDTO> listarCursosComMatriculado(Long idEstudante);
}
