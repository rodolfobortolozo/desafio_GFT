package io.github.rodolfobortolozo.arquitetura.core.security.model.dto;

public record LoginRequest(

        String usuario,
        String senha
) {
}
