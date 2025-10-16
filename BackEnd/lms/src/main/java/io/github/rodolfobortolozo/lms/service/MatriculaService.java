package io.github.rodolfobortolozo.lms.service;

import io.github.rodolfobortolozo.lms.model.Curso;
import io.github.rodolfobortolozo.lms.model.Estudante;
import io.github.rodolfobortolozo.lms.model.Matricula;
import io.github.rodolfobortolozo.lms.repository.CursoRepository;
import io.github.rodolfobortolozo.lms.repository.EstudanteRepository;
import io.github.rodolfobortolozo.lms.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final EstudanteService estudanteService;
    private final CursoService cursoService;
    private final ParametroService parametroService;

    public MatriculaService(MatriculaRepository matriculaRepository, EstudanteRepository estudanteRepository, CursoRepository cursoRepository, EstudanteService estudanteService, CursoService cursoService, ParametroService parametroService) {
        this.matriculaRepository = matriculaRepository;
        this.estudanteService = estudanteService;
        this.cursoService = cursoService;
        this.parametroService = parametroService;
    }

    public Matricula matriculaEstudante(Long idEstudante, Long idCurso){
        Estudante estudante = estudanteService.pesquisaEstudante(idEstudante);
        Curso curso = cursoService.pesquisarCurso(idCurso);

        verificarMatriculaAtiva(estudante, curso);
        verificarQtdCursoSimultaneo(estudante, curso);

        Matricula matricula = new Matricula();
        matricula.setEstudante(estudante);
        matricula.setCurso(curso);
        matricula.setDataMatricula(LocalDate.now());
        matricula.setStatus("ATIVA");

        return matriculaRepository.save(matricula);
    }

    private void verificarMatriculaAtiva(Estudante estudante, Curso curso){
        boolean matriculaAtiva = matriculaRepository.existsByEstudanteAndCursoAndStatusEquals(
                estudante, curso, "ATIVA");

        if (matriculaAtiva) {
            throw new RuntimeException("O estudante já está matriculado neste curso.");
        }
    }

    private void verificarQtdCursoSimultaneo(Estudante estudante, Curso curso){
        int qtdCurso = matriculaRepository.qtdCursosAtivo("ATIVA", estudante);
        if(qtdCurso >= parametroService.retornaParametros().getQtdCursoSimultaneo()){
            throw new RuntimeException("O estudante já está atingiu a quantidade de cursos para se matricular");
        }
    }
}
