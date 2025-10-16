package io.github.rodolfobortolozo.lms.model;

import io.github.rodolfobortolozo.arquitetura.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TB006_CATEGORIATAREFA")
@Data
public class CategoriaTarefa extends BaseEntity<Long>{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCATEGORIA")
    private long id;
	
	@Column(name = "DESCRICAO")
	private String descricao;

}
