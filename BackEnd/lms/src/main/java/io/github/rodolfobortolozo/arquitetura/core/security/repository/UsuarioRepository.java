package io.github.rodolfobortolozo.arquitetura.core.security.repository;

import io.github.rodolfobortolozo.arquitetura.core.security.model.Usuario;
import io.github.rodolfobortolozo.arquitetura.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    Optional<Usuario> findByUsuario(String usuario);
}
