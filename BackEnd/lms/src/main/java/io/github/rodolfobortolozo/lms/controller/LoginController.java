package io.github.rodolfobortolozo.lms.controller;

import io.github.rodolfobortolozo.arquitetura.core.security.JWTUtil;
import io.github.rodolfobortolozo.arquitetura.core.security.UsuarioDetailsService;
import io.github.rodolfobortolozo.arquitetura.core.security.model.Usuario;
import io.github.rodolfobortolozo.arquitetura.core.security.model.dto.LoginRequest;
import io.github.rodolfobortolozo.arquitetura.core.security.model.dto.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/login")
public class LoginController {

    private final UsuarioDetailsService usuarioDetailsService;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authManager;

    public LoginController(UsuarioDetailsService usuarioDetailsService, JWTUtil jwtUtil, AuthenticationManager authManager) {
        this.usuarioDetailsService = usuarioDetailsService;
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
    }

    @PostMapping()
    public ResponseEntity<LoginResponse> loginUsuario(@RequestBody LoginRequest usuarioLogin){
        try {

           Usuario usuarioExistente = usuarioDetailsService.buscarUsuario(usuarioLogin.usuario());

            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(usuarioLogin.usuario(), usuarioLogin.senha());

            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(usuarioExistente);

            LoginResponse loginResponse = new LoginResponse(usuarioExistente,token);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(loginResponse);

        }catch (AuthenticationException authExc){

            throw new RuntimeException("Credenciais Inválidas");
        }
    }

}
