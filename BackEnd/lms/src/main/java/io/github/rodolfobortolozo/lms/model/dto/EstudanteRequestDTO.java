package io.github.rodolfobortolozo.lms.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record EstudanteRequestDTO(
        String nome,
        String sobrenome,
        String email,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        String telefone,
        String senha ) {
}
