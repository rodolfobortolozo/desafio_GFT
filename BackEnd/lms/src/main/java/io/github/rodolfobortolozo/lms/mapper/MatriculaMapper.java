package io.github.rodolfobortolozo.lms.mapper;

import io.github.rodolfobortolozo.lms.model.Estudante;
import io.github.rodolfobortolozo.lms.model.Matricula;
import io.github.rodolfobortolozo.lms.model.dto.EstudanteRequestDTO;
import io.github.rodolfobortolozo.lms.model.dto.EstudanteResponseDTO;
import io.github.rodolfobortolozo.lms.model.dto.MatriculaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MatriculaMapper {

    Matricula toEntity(MatriculaDTO matriculaDTO);

}
