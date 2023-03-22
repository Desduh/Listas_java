package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.modelo.ClienteAtualizador;
import com.autobots.automanager.modelo.ClienteSelecionador;
import com.autobots.automanager.modelo.DocumentoAdicionador;
import com.autobots.automanager.modelo.Exclusor;
import com.autobots.automanager.modelo.TelefoneAdicionador;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@RestController
public class Controle {
	@Autowired
	private ClienteRepositorio repositorio;
	@Autowired
	private ClienteSelecionador selecionador;

	@GetMapping("/cliente/{id}")
	public Cliente obterCliente(@PathVariable long id) {
		List<Cliente> clientes = repositorio.findAll();
		return selecionador.selecionar(clientes, id);
	}

	@GetMapping("/visualizar")
	public List<Cliente> obterClientes() {
		List<Cliente> clientes = repositorio.findAll();
		return clientes;
	}

	@PostMapping("/cadastro")
	public void cadastrarCliente(@RequestBody Cliente cliente) {
		repositorio.save(cliente);
	}
	
	@PutMapping("/adicao/documento")
	public void adicionarDocumento(@RequestBody Cliente adicao) {
		Cliente cliente = repositorio.getById(adicao.getId());
		DocumentoAdicionador adicionador = new DocumentoAdicionador();
		adicionador.adicionar(cliente, adicao);
		repositorio.save(cliente);
	}
	
	@PutMapping("/adicao/telefone")
	public void adicionarTelefone(@RequestBody Cliente adicao) {
		Cliente cliente = repositorio.getById(adicao.getId());
		TelefoneAdicionador adicionador = new TelefoneAdicionador();
		adicionador.adicionar(cliente, adicao);
		repositorio.save(cliente);
	}

	@PutMapping("/atualizar")
	public void atualizarCliente(@RequestBody Cliente atualizacao) {
		Cliente cliente = repositorio.getById(atualizacao.getId());
		ClienteAtualizador atualizador = new ClienteAtualizador();
		atualizador.atualizar(cliente, atualizacao);
		repositorio.save(cliente);
	}


	@DeleteMapping("/excluir")
	public void excluirCliente(@RequestBody Cliente exclusao) {
		Cliente cliente = repositorio.getById(exclusao.getId());
		repositorio.delete(cliente);
	}
	
	@DeleteMapping("/excluir/dado")
	public void excluirDocumento(@RequestBody Cliente exclusao) {
		Cliente cliente = repositorio.getById(exclusao.getId());
		Exclusor exclusor = new Exclusor();
		exclusor.excluir(cliente, exclusao);
		repositorio.save(cliente);
	}
}
