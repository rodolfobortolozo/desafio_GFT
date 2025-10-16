package io.github.rodolfobortolozo.lms.model;

import io.github.rodolfobortolozo.arquitetura.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TB003_CURSO")
@Data
public class Curso extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="IDCURSO")
    private Long id;

    @Column(name = "NOMECURSO")
    private String nome;

    @Column(name = "DESCRICAOCURSO")
    private String descricao;

}
