package io.github.rodolfobortolozo.lms.controller;

import io.github.rodolfobortolozo.lms.mapper.MatriculaMapper;
import io.github.rodolfobortolozo.lms.model.Matricula;
import io.github.rodolfobortolozo.lms.model.dto.MatriculaDTO;
import io.github.rodolfobortolozo.lms.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/matricula")
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final MatriculaMapper mapper;

    public MatriculaController(MatriculaService matriculaService, MatriculaMapper mapper) {
        this.matriculaService = matriculaService;
        this.mapper = mapper;
    }


    @PostMapping
    public ResponseEntity<Matricula> cadastrarMatricula(@RequestBody MatriculaDTO matriculaDTO){

        return ResponseEntity.ok(matriculaService.matriculaEstudante(matriculaDTO.idEstudante(), matriculaDTO.idCurso()));

    }

}
