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
import com.autobots.automanager.modelo.Exclusor;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@RestController
public class ControleCliente {
	@Autowired
	private ClienteRepositorio repositorioCliente;
	@Autowired
	private ClienteSelecionador selecionador;

	@GetMapping("/cliente/{id}")
	public Cliente obterCliente(@PathVariable long id) {
		List<Cliente> clientes = repositorioCliente.findAll();
		return selecionador.selecionar(clientes, id);
	}

	@GetMapping("/visualizar/clientes")
	public List<Cliente> obterClientes() {
		List<Cliente> clientes = repositorioCliente.findAll();
		return clientes;
	}

	@PostMapping("/cadastro")
	public void cadastrarCliente(@RequestBody Cliente cliente) {
		repositorioCliente.save(cliente);
	}

	@PutMapping("/atualizar")
	public void atualizarCliente(@RequestBody Cliente atualizacao) {
		Cliente cliente = repositorioCliente.getById(atualizacao.getId());
		ClienteAtualizador atualizador = new ClienteAtualizador();
		atualizador.atualizar(cliente, atualizacao);
		repositorioCliente.save(cliente);
	}

	@DeleteMapping("/cliente/excluir")
	public void excluirCliente(@RequestBody Cliente exclusao) {
		Cliente cliente = repositorioCliente.getById(exclusao.getId());
		repositorioCliente.delete(cliente);
	}
	
	@DeleteMapping("/excluir/dado")
	public void excluirDocumento(@RequestBody Cliente exclusao) {
		Cliente cliente = repositorioCliente.getById(exclusao.getId());
		Exclusor exclusor = new Exclusor();
		exclusor.excluir(cliente, exclusao);
		repositorioCliente.save(cliente);
	}
}
