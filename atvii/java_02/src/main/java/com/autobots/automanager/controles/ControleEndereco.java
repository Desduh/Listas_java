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
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.modelos.AcharCliente;
import com.autobots.automanager.modelos.AdicionarLinkEndereco;
import com.autobots.automanager.modelos.EnderecoAdicionador;
import com.autobots.automanager.modelos.Exclusor;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.EnderecoRepositorio;

@RestController
public class ControleEndereco {
	@Autowired
	private EnderecoRepositorio repositorioEndereco;
	@Autowired
	private ClienteRepositorio repositorioCliente;
	@Autowired
	private AdicionarLinkEndereco adicionadorLink;
	
	@GetMapping("/visualizar/enderecos")
	public ResponseEntity<List<Endereco>> obterEnderecos() {
		List<Endereco> enderecos = repositorioEndereco.findAll();
		if (enderecos.isEmpty()) {
			ResponseEntity<List<Endereco>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(enderecos);
			ResponseEntity<List<Endereco>> resposta = new ResponseEntity<>(enderecos, HttpStatus.FOUND);
			return resposta;
		}
	}
	
	@PutMapping("/adicao/endereco/{id}")
	public void adicionarDocumento(@RequestBody Endereco adicao,@PathVariable long id) {
		Cliente cliente = repositorioCliente.getById(id);
		EnderecoAdicionador adicionador = new EnderecoAdicionador();
		adicionador.adicionar(cliente, adicao);
		repositorioCliente.save(cliente);
	}
	
	@DeleteMapping("/excluir/endereco/{id_end}/cliente/{id_cli}")
	public ResponseEntity<?> excluirEndereco(@PathVariable long id_end,@PathVariable long id_cli) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Cliente cliente = repositorioCliente.getById(id_cli);
		Endereco endereco = repositorioEndereco.getById(id_end);
		if (cliente != null) {
			Exclusor exclusor = new Exclusor();
			exclusor.excluirEnderecos(cliente, endereco);
			repositorioCliente.save(cliente);
			repositorioEndereco.delete(endereco);
		}
		return new ResponseEntity<>(status);
	}
}
