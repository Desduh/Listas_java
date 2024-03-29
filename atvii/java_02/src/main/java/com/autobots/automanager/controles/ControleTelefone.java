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
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelos.TelefoneAdicionador;
import com.autobots.automanager.modelos.AdicionadorLinkTelefone;
import com.autobots.automanager.modelos.Selecionador;
import com.autobots.automanager.modelos.TelefoneAtualizador;
import com.autobots.automanager.modelos.TelefoneExclusor;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

@RestController
public class ControleTelefone {
	@Autowired
	private ClienteRepositorio repositorioCliente;
	@Autowired
	private TelefoneRepositorio repositorioTelefone;	
	@Autowired
	private AdicionadorLinkTelefone adicionadorLink;
	
	@GetMapping("/visualizar/telefones")
	public ResponseEntity<List<Telefone>> obterTelefones() {
		List<Telefone> telefones = repositorioTelefone.findAll();		
		if (telefones.isEmpty()) {
			ResponseEntity<List<Telefone>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(telefones);
			ResponseEntity<List<Telefone>> resposta = new ResponseEntity<>(telefones, HttpStatus.FOUND);
			return resposta;
		}
	}
	
	@GetMapping("/telefone/{id}")
	public ResponseEntity<Telefone> obterTelefone(@PathVariable long id) {
		List<Telefone> telefones = repositorioTelefone.findAll();
		Telefone telefone = Selecionador.telefoneSelecionador(telefones, id);
		if (telefone == null) {
			ResponseEntity<Telefone> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
			return resposta;
		} else {
			adicionadorLink.adicionarLink(telefone);
			ResponseEntity<Telefone> resposta = new ResponseEntity<Telefone>(telefone, HttpStatus.FOUND) ;
			return resposta;
		}
	}
	
	@PutMapping("/atualizar/telefone")
	public ResponseEntity<?> atualizarTelefone(@RequestBody Telefone atualizacao) {
		HttpStatus status = HttpStatus.CONFLICT;
		Telefone telefone = repositorioTelefone.getById(atualizacao.getId());
		if (telefone != null) {
			TelefoneAtualizador atualizador = new TelefoneAtualizador();
			atualizador.atualizar(telefone, atualizacao);
			repositorioTelefone.save(telefone);
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(status);
	}
	
	@DeleteMapping("/excluir/telefone/{id}")
	public ResponseEntity<?> excluirTelefone(@PathVariable long id) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		List<Cliente> clientes = repositorioCliente.findAll();
		Telefone telefone = repositorioTelefone.getById(id);		
		TelefoneExclusor excluir = new TelefoneExclusor();
		List<Cliente> removido = excluir.excluir(clientes, telefone);
		repositorioCliente.saveAll(removido);
		return new ResponseEntity<>(status);
	}
	
	@PutMapping("/adicao/telefone")
	public void adicionarTelefone(@RequestBody Cliente adicao) {
		Cliente cliente = repositorioCliente.getById(adicao.getId());
		TelefoneAdicionador adicionador = new TelefoneAdicionador();
		adicionador.adicionar(cliente, adicao);
		repositorioCliente.save(cliente);
	}
}