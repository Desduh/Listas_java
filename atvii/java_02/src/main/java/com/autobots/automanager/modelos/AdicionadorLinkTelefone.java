package com.autobots.automanager.modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.ControleDocumento;
import com.autobots.automanager.controles.ControleTelefone;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@Component
public class AdicionadorLinkTelefone implements AdicionadorLink<Telefone> {
	@Autowired
	private ClienteRepositorio repositorioCliente;
	@Override
	public void adicionarLink(List<Telefone> lista) {
		List<Cliente> clientes = repositorioCliente.findAll();
		for (Telefone telefone : lista) {
			for (Cliente cliente : clientes) {
				for (Telefone cli_tel : cliente.getTelefones()) {
					if(cli_tel.getId() == telefone.getId()) {
						Link linkProprio = WebMvcLinkBuilder
								.linkTo(WebMvcLinkBuilder
										.methodOn(ControleTelefone.class)
										.excluirTelefone(telefone.getId(),cliente.getId()))
								.withRel("Excluir telefone");
						telefone.add(linkProprio);
					}
				}
			}
		}
	}

	@Override
	public void adicionarLink(Telefone objeto) {
		// TODO Auto-generated method stub
		
	}
}
