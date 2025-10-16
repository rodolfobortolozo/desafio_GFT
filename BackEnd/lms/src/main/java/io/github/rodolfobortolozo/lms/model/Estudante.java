package io.github.rodolfobortolozo.lms.model;

import io.github.rodolfobortolozo.arquitetura.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "TB002_ESTUDANTE")
@Data
public class Estudante extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="IDESTUDANTE")
    private Long id;

    @Column(name ="NOME")
    private String nome;

    @Column(name ="SOBRENOME")
    private String sobrenome;

    @Column(name ="EMAIL")
    private String email;

    @Column(name = "DATANASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name ="TELEFONE")
    private String telefone;

    @Column(name ="SENHA")
    private String senha;

}
