package io.github.rodolfobortolozo.lms.controller;

import io.github.rodolfobortolozo.lms.mapper.CursoMapper;
import io.github.rodolfobortolozo.lms.model.Curso;
import io.github.rodolfobortolozo.lms.model.dto.CursoDTO;
import io.github.rodolfobortolozo.lms.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;
    private final CursoMapper mapper;

    public CursoController(CursoService cursoService, CursoMapper mapper) {
        this.cursoService = cursoService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listarTodos(){
        List<CursoDTO> cursos = cursoService.pesquisarTodos()
                .stream()
                .map(curso -> mapper.toResponse(curso)).toList();

        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> cadastrar(@RequestBody CursoDTO cursoDTO){
        Curso curso = cursoService.cadastrar(mapper.toEntity(cursoDTO));
        return ResponseEntity.ok(mapper.toResponse(curso));
    }

    @PutMapping("{id}")
    public ResponseEntity<CursoDTO> atualizar(@PathVariable  Long id, @RequestBody CursoDTO cursoDTO){
        Curso curso = cursoService.atualizar(id, mapper.toEntity(cursoDTO));
        return ResponseEntity.ok(mapper.toResponse(curso));
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        cursoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<CursoDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(mapper.toResponse(cursoService.pesquisarCurso(id)));
    }

    @GetMapping("/matriculado/{id}")
    public ResponseEntity<List<CursoDTO>> buscarMatriculados(@PathVariable Long id){
        return ResponseEntity.ok(cursoService.pesquisarCursosMatriculados(id));
    }

}
