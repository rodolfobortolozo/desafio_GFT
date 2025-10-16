package io.github.rodolfobortolozo.lms.model;

import java.time.LocalDate;

import io.github.rodolfobortolozo.arquitetura.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TB007_TAREFA")
@Data
public class Tarefa extends BaseEntity<Long> {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "IDTAREFA")
	 private long id;
	 
	 @Column(name = "DESCRICAO")
	 private String descricao;
	 
	 @Column(name = "DATA")
	 private LocalDate data;
	 
	 @Column(name = "TEMPO")
	 private Long tempo;
	 
	 @ManyToOne
	 @JoinColumn(name = "IDCATEGORIA")
	 private CategoriaTarefa categoriaTarefa;
	 
}
