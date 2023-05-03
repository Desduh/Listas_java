package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.modelo.DocumentoAdicionador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.DocumentosRepositorio;

@RestController
public class ControleDocumento {
	@Autowired
	private DocumentosRepositorio repositorioDocumento;
	@Autowired
	private ClienteRepositorio repositorioCliente;
	
	@GetMapping("/visualizar/documentos")
	public List<Documento> obterDocumentos() {
		List<Documento> documentos = repositorioDocumento.findAll();
		return documentos;
	}
	
	@PutMapping("/adicao/documento")
	public void adicionarDocumento(@RequestBody Cliente adicao) {
		Cliente cliente = repositorioCliente.getById(adicao.getId());
		DocumentoAdicionador adicionador = new DocumentoAdicionador();
		adicionador.adicionar(cliente, adicao);
		repositorioCliente.save(cliente);
	}
}
