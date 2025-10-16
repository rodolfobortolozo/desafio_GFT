package io.github.rodolfobortolozo.lms.model;

import io.github.rodolfobortolozo.arquitetura.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TB001_PARAMETRO")
@Data
public class Parametro extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPARAMETRO")
    private long id;

    @Column(name = "IDADEMINIMA")
    private long idadeMinima;

    @Column(name = "QTDCURSOSIMULTANEO")
    private long qtdCursoSimultaneo;

}
