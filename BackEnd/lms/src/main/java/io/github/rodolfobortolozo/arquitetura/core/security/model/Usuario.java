package io.github.rodolfobortolozo.arquitetura.core.security.model;

import io.github.rodolfobortolozo.arquitetura.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "VIEW001_USUARIOS")
@Immutable
@Data
public class Usuario extends BaseEntity<Long> {

    @Id
    @Column(name = "IDLOGIN")
    private Long id;

    private String nome;

    private String usuario;

    private String senha;

    private String permissao;

}
