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
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelos.Exclusor;
import com.autobots.automanager.modelos.TelefoneAdicionador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

@RestController
public class ControleTelefone {
	@Autowired
	private TelefoneRepositorio repositorioTelefone;	
	@Autowired
	private ClienteRepositorio repositorioCliente;
	
	@GetMapping("/visualizar/telefones")
	public List<Telefone> obterTelefones() {
		List<Telefone> telefones = repositorioTelefone.findAll();
		return telefones;
	}
	
	@PutMapping("/adicao/telefone")
	public ResponseEntity<?> adicionarTelefone(@RequestBody Cliente adicao) {
		HttpStatus status = HttpStatus.CONFLICT;
		if (adicao.getId() == null) {
			Cliente cliente = repositorioCliente.getById(adicao.getId());
			TelefoneAdicionador adicionador = new TelefoneAdicionador();
			adicionador.adicionar(cliente, adicao);
			repositorioCliente.save(cliente);
		}
		return new ResponseEntity<>(status);
	}
	
	@DeleteMapping("/excluir/telefone/{id_tel}/cliente/{id_cli}")
	public ResponseEntity<?> excluirDocumento(@PathVariable long id_tel,@PathVariable long id_cli) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Cliente cliente = repositorioCliente.getById(id_cli);
		Telefone telefone = repositorioTelefone.getById(id_tel);
		if (cliente != null) {
			Exclusor exclusor = new Exclusor();
			exclusor.excluirTelefones(cliente, telefone);
			repositorioCliente.save(cliente);
		}
		return new ResponseEntity<>(status);
	}
}