package com.autobots.automanager.modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.ControleEndereco;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@Component
public class AdicionarLinkEndereco implements AdicionadorLink<Endereco> {
	@Autowired
	private ClienteRepositorio repositorioCliente;
	@Override
	public void adicionarLink(List<Endereco> lista) {
		List<Cliente> clientes = repositorioCliente.findAll();
		for (Endereco endereco : lista) {
			for (Cliente cliente : clientes) {
				if(cliente.getEndereco().getId() == endereco.getId()) {
					Link linkProprio = WebMvcLinkBuilder
							.linkTo(WebMvcLinkBuilder
									.methodOn(ControleEndereco.class)
									.excluirEndereco(cliente.getEndereco().getId(),cliente.getId()))
							.withRel("Excluir endereço");
					endereco.add(linkProprio);
				}
			}
		}
	}

	@Override
	public void adicionarLink(Endereco objeto) {
		// TODO Auto-generated method stub
		
	}
}
