package io.github.rodolfobortolozo.lms.controller;

import io.github.rodolfobortolozo.lms.mapper.EstudanteMapper;
import io.github.rodolfobortolozo.lms.model.Estudante;
import io.github.rodolfobortolozo.lms.model.dto.EstudanteRequestDTO;
import io.github.rodolfobortolozo.lms.model.dto.EstudanteResponseDTO;
import io.github.rodolfobortolozo.lms.service.EstudanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/estudante")
public class EstudanteController {

    private final EstudanteService estudanteService;
    private final EstudanteMapper mapper;

    public EstudanteController(EstudanteService estudanteService, EstudanteMapper mapper) {
        this.estudanteService = estudanteService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<EstudanteResponseDTO> cadastrarEstudante(@RequestBody EstudanteRequestDTO estudanteRequestDTO){

        Estudante estudante = estudanteService.cadastrarEstudante(mapper.toEntity(estudanteRequestDTO));

        return ResponseEntity.ok(mapper.toResponse(estudante));

    }

}
