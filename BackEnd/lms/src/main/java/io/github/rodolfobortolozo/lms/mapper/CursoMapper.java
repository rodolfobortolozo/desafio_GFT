package io.github.rodolfobortolozo.lms.mapper;

import io.github.rodolfobortolozo.lms.model.Curso;
import io.github.rodolfobortolozo.lms.model.dto.CursoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CursoMapper {

    Curso toEntity (CursoDTO cursoDTO);
    CursoDTO toResponse (Curso curso);

    @Mapping(target = "id", ignore = true)
    void updateFromDto(CursoDTO dto, @MappingTarget Curso entity);
}
