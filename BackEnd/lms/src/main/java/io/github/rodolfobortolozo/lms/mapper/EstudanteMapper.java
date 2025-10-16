package io.github.rodolfobortolozo.lms.mapper;

import io.github.rodolfobortolozo.lms.model.Estudante;
import io.github.rodolfobortolozo.lms.model.dto.EstudanteRequestDTO;
import io.github.rodolfobortolozo.lms.model.dto.EstudanteResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EstudanteMapper {

    Estudante toEntity(EstudanteRequestDTO estudanteRequestDTO);
    EstudanteResponseDTO toResponse(Estudante estudante);

}
