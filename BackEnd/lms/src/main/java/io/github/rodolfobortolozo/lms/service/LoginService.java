package io.github.rodolfobortolozo.lms.service;

import io.github.rodolfobortolozo.arquitetura.core.security.JWTUtil;
import io.github.rodolfobortolozo.arquitetura.core.security.UsuarioDetailsService;
import io.github.rodolfobortolozo.arquitetura.core.security.model.Usuario;
import io.github.rodolfobortolozo.arquitetura.core.security.model.dto.LoginResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Optional;

public class LoginService {

    private final UsuarioDetailsService usuarioDetailsService;
    private final AuthenticationManager authManager;
    private final JWTUtil jwtUtil;

    public LoginService(UsuarioDetailsService usuarioDetailsService, AuthenticationManager authManager, JWTUtil jwtUtil) {
        this.usuarioDetailsService = usuarioDetailsService;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse loginusuario(String usuario){
        Usuario usuarioExistente = usuarioDetailsService.buscarUsuario(usuario);

        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(usuarioExistente.getUsuario(), usuarioExistente.getSenha());

        authManager.authenticate(authInputToken);

        String token = jwtUtil.generateToken(usuarioExistente);

        LoginResponse loginResponse = new LoginResponse(usuarioExistente,token);

        return loginResponse;
    }
}
