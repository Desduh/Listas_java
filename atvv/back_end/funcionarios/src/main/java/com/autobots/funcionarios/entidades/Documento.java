package com.autobots.funcionarios.entidades;


import jakarta.persistence.*;
import com.autobots.automanager.enums.TipoDocumento;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
@Entity
public class Documento extends RepresentationModel<Documento> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private TipoDocumento tipo;
	@Column(nullable = false)
	private Date dataEmissao;
	@Column(unique = true, nullable = false)
	private String numero;
}