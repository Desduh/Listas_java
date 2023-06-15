package com.autobots.veiculos.entidades;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String endereco;
}