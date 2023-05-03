package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.modelos.AdicionadorLinkDocumentos;
import com.autobots.automanager.modelos.AdicionarLinkEndereco;
import com.autobots.automanager.modelos.DocumentoAdicionador;
import com.autobots.automanager.modelos.Exclusor;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.DocumentosRepositorio;

@RestController
public class ControleDocumento {
	@Autowired
	private DocumentosRepositorio repositorioDocumento;
	@Autowired
	private ClienteRepositorio repositorioCliente;
	@Autowired
	private AdicionadorLinkDocumentos adicionadorLink;
	
	@GetMapping("/visualizar/documentos")
	public ResponseEntity<List<Documento>> obterDocumentos() {
		List<Documento> documentos = repositorioDocumento.findAll();		
		if (documentos.isEmpty()) {
			ResponseEntity<List<Documento>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(documentos);
			ResponseEntity<List<Documento>> resposta = new ResponseEntity<>(documentos, HttpStatus.FOUND);
			return resposta;
		}
	}
	
	@PutMapping("/adicao/documento")
	public ResponseEntity<?> adicionarDocumento(@RequestBody Cliente adicao) {
		HttpStatus status = HttpStatus.CONFLICT;
		if (adicao.getId() == null) {
			Cliente cliente = repositorioCliente.getById(adicao.getId());
			DocumentoAdicionador adicionador = new DocumentoAdicionador();
			adicionador.adicionar(cliente, adicao);
			repositorioCliente.save(cliente);
		}
		return new ResponseEntity<>(status);
	}
	
	@DeleteMapping("/excluir/documento/{id_doc}/cliente/{id_cli}")
	public ResponseEntity<?> excluirDocumento(@PathVariable long id_doc,@PathVariable long id_cli) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Cliente cliente = repositorioCliente.getById(id_cli);
		Documento documento = repositorioDocumento.getById(id_doc);
		if (cliente != null) {
			Exclusor exclusor = new Exclusor();
			exclusor.excluirDocumentos(cliente, documento);
			repositorioCliente.save(cliente);
		}
		return new ResponseEntity<>(status);
	}
}