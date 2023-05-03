package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.modelo.EnderecoAdicionador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.EnderecoRepositorio;

@RestController
public class ControleEndereco {
	@Autowired
	private EnderecoRepositorio repositorioEndereco;
	@Autowired
	private ClienteRepositorio repositorioCliente;
	
	@GetMapping("/visualizar/enderecos")
	public List<Endereco> obterEnderecos() {
		List<Endereco> enderecos = repositorioEndereco.findAll();
		return enderecos;
	}
	
	@PutMapping("/adicao/endereco")
	public void adicionarDocumento(@RequestBody Cliente adicao) {
		Cliente cliente = repositorioCliente.getById(adicao.getId());
		EnderecoAdicionador adicionador = new EnderecoAdicionador();
		adicionador.adicionar(cliente, adicao);
		repositorioCliente.save(cliente);
	}
}
