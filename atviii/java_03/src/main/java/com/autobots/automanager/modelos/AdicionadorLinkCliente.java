package com.autobots.automanager.modelos;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.ControleCliente;
import com.autobots.automanager.entidades.Cliente;

@Component
public class AdicionadorLinkCliente implements AdicionadorLink<Cliente> {

	@Override
	public void adicionarLink(List<Cliente> lista) {
		for (Cliente cliente : lista) {
			long id = cliente.getId();
			Link linkProprio = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ControleCliente.class)
							.obterCliente(id))
					.withSelfRel();
			cliente.add(linkProprio);
		}
	}

	@Override
	public void adicionarLink(Cliente objeto) {
		Link obterClientes = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleCliente.class)
						.obterClientes())
				.withRel("clientes");
		Link excluirCliente = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleCliente.class)
						.excluirCliente(objeto.getId()))
				.withRel("excluir_cliente");
		Link atualizarCliente = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleCliente.class)
						.atualizarCliente(objeto,objeto.getId()))
				.withRel("atualizar_cliente");
		objeto.add(obterClientes,excluirCliente, atualizarCliente);
	}
}