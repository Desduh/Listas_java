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
import com.autobots.automanager.modelos.DocumentoAtualizador;
import com.autobots.automanager.modelos.EnderecoAtualizador;
import com.autobots.automanager.modelos.Exclusor;
import com.autobots.automanager.modelos.Selecionador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.DocumentosRepositorio;

@RestController
public class ControleDocumento {
	@Autowired
	private DocumentosRepositorio repositorioDocumento;
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
	
	@GetMapping("/documento/{id}")
	public ResponseEntity<Documento> obterDocumento(@PathVariable long id) {
		List<Documento> documentos = repositorioDocumento.findAll();
		Documento documento = Selecionador.documentoSelecionador(documentos, id);
		if (documento == null) {
			ResponseEntity<Documento> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
			return resposta;
		} else {
			adicionadorLink.adicionarLink(documento);
			ResponseEntity<Documento> resposta = new ResponseEntity<Documento>(documento, HttpStatus.FOUND) ;
			return resposta;
		}
	}
	
	@PutMapping("/atualizar/documento")
	public ResponseEntity<?> atualizarDocumento(@RequestBody Documento atualizacao) {
		HttpStatus status = HttpStatus.CONFLICT;
		Documento documento = repositorioDocumento.getById(atualizacao.getId());
		if (documento != null) {
			DocumentoAtualizador atualizador = new DocumentoAtualizador();
			atualizador.atualizar(documento, atualizacao);
			repositorioDocumento.save(documento);
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(status);
	}
	
	@DeleteMapping("/excluir/documento/{id}")
	public ResponseEntity<?> excluirDocumento(@PathVariable long id) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Documento documento = repositorioDocumento.getById(id);
		if (documento != null) {
			repositorioDocumento.delete(documento);
			status = HttpStatus.OK;
		}
		return new ResponseEntity<>(status);
	}
}