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
import com.autobots.automanager.modelos.EnderecoAdicionador;
import com.autobots.automanager.modelos.EnderecoAtualizador;
import com.autobots.automanager.modelos.EnderecoExclusor;
import com.autobots.automanager.modelos.Selecionador;
import com.autobots.automanager.modelos.AdicionarLinkEndereco;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.EnderecoRepositorio;

@RestController
public class ControleEndereco {
	@Autowired
	private ClienteRepositorio repositorioCliente;
	@Autowired
	private EnderecoRepositorio repositorioEndereco;
	@Autowired
	private AdicionarLinkEndereco adicionadorLink;
	
	@GetMapping("/visualizar/enderecos")
	public ResponseEntity<List<Endereco>> obterEnderecos() {
		List<Endereco> enderecos = repositorioEndereco.findAll();
		if (enderecos.isEmpty()) {
			ResponseEntity<List<Endereco>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
			return resposta;
		} else {
			adicionadorLink.adicionarLink(enderecos);
			ResponseEntity<List<Endereco>> resposta = new ResponseEntity<>(enderecos, HttpStatus.FOUND) ;
			return resposta;
		}
	}
	
	@GetMapping("/endereco/{id}")
	public ResponseEntity<Endereco> obterEndereco(@PathVariable long id) {
		List<Endereco> enderecos = repositorioEndereco.findAll();
		Endereco endereco = Selecionador.enderecoSelecionador(enderecos, id);
		if (endereco == null) {
			ResponseEntity<Endereco> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
			return resposta;
		} else {
			adicionadorLink.adicionarLink(endereco);
			ResponseEntity<Endereco> resposta = new ResponseEntity<Endereco>(endereco, HttpStatus.FOUND) ;
			return resposta;
		}
	}
	
	@PutMapping("/atualizar/endereco")
	public ResponseEntity<?> atualizarEndereco(@RequestBody Endereco atualizacao) {
		HttpStatus status = HttpStatus.CONFLICT;
		Endereco endereco = repositorioEndereco.getById(atualizacao.getId());
		if (endereco != null) {
			EnderecoAtualizador atualizador = new EnderecoAtualizador();
			atualizador.atualizar(endereco, atualizacao);
			repositorioEndereco.save(endereco);
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(status);
	}
	
	@DeleteMapping("/excluir/endereco/{id}")
	public ResponseEntity<?> excluirEndereco(@PathVariable long id) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		List<Cliente> clientes = repositorioCliente.findAll();
		EnderecoExclusor exclusor = new EnderecoExclusor();
		List<Cliente> removido = exclusor.excluirEndereco(id, clientes);
		repositorioCliente.saveAll(removido);
		return new ResponseEntity<>(status);
	}
	
	@PutMapping("/adicao/endereco")
	public void adicionarDocumento(@RequestBody Cliente adicao) {
		Cliente cliente = repositorioCliente.getById(adicao.getId());
		EnderecoAdicionador adicionador = new EnderecoAdicionador();
		adicionador.adicionar(cliente, adicao);
		repositorioCliente.save(cliente);
	}
}
