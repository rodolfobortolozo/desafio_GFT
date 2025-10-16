package io.github.rodolfobortolozo.lms.service;

import io.github.rodolfobortolozo.lms.model.Curso;
import io.github.rodolfobortolozo.lms.model.dto.CursoDTO;
import io.github.rodolfobortolozo.lms.repository.CursoRepository;
import io.github.rodolfobortolozo.lms.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final MatriculaRepository matriculaRepository;


    public CursoService(CursoRepository cursoRepository, MatriculaRepository matriculaRepository) {
        this.cursoRepository = cursoRepository;
        this.matriculaRepository = matriculaRepository;
    }

    public Curso cadastrar(Curso curso){
        if(cursoRepository.existsByNome(curso.getNome())){
            throw new RuntimeException("Curso ja foi cadastrado");
        }
        return cursoRepository.save(curso);
    }

    public Curso atualizar(Long id, Curso curso){
        Curso cursoExistente =  pesquisarCurso(id);

        curso.setId(cursoExistente.getId());
        return cursoRepository.save(curso);
    }

    public void excluir(Long id){
        Curso curso = pesquisarCurso(id);
        cursoRepository.delete(curso);
    }

    public Curso pesquisarCurso(Long id){
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public List<Curso> pesquisarTodos(){
        return cursoRepository.findAll();
    }

    public List<CursoDTO> pesquisarCursosMatriculados(Long id){
        return cursoRepository.listarCursosComMatriculado(id);
    }
}
