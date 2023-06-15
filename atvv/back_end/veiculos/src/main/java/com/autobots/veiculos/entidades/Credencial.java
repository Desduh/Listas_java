package com.autobots.veiculos.entidades;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Credencial {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Date criacao;
	@Column()
	private Date ultimoAcesso;
	@Column(nullable = false)
	private boolean inativo;
}