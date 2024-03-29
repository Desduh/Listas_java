package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.TelefoneAdicionador;
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
	public void adicionarTelefone(@RequestBody Cliente adicao) {
		Cliente cliente = repositorioCliente.getById(adicao.getId());
		TelefoneAdicionador adicionador = new TelefoneAdicionador();
		adicionador.adicionar(cliente, adicao);
		repositorioCliente.save(cliente);
	}
}
