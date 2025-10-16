package io.github.rodolfobortolozo.arquitetura.core.security;


import io.github.rodolfobortolozo.arquitetura.core.security.model.Usuario;
import io.github.rodolfobortolozo.arquitetura.core.security.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Usuario user = buscarUsuario(usuario);

        return new User(user.getUsuario(), user.getSenha(), new ArrayList<>());
    }

    public Usuario buscarUsuario(String usuario){
        return usuarioRepository.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    }


}