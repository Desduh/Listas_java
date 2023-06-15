package com.autobots.funcionarios.entidades;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Entity
public class Telefone extends RepresentationModel<Telefone> {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String ddd;
	@Column
	private String numero;
}