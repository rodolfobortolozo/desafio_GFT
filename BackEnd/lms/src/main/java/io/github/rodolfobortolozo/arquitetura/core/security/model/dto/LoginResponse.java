package io.github.rodolfobortolozo.arquitetura.core.security.model.dto;

import io.github.rodolfobortolozo.arquitetura.core.security.model.Usuario;

public record LoginResponse(
        Long id,
        String nome,
        String email,
        String nivel,
        String token

) {

    public LoginResponse(Usuario usuario, String token){
        this(usuario.getId(), usuario.getNome(), usuario.getUsuario(), usuario.getPermissao(), token);
    }
}