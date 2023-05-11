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

	@Override
	public void adicionarLink(List<Telefone> lista) {
		for (Telefone telefone : lista) {
			long id = telefone.getId();
			Link linkProprioTelefone = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ControleTelefone.class)
							.obterTelefone(id))
					.withSelfRel();
			telefone.add(linkProprioTelefone);
		}
	}

	@Override
	public void adicionarLink(Telefone objeto) {
		long id = objeto.getId();
		Link linkProprioTelefones = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleTelefone.class)
						.obterTelefones())
				.withRel("telefones");
		Link linkProprioAtualizar = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleTelefone.class)
						.atualizarTelefone(objeto))
				.withRel("atualizar_telefone");
		Link linkProprioExcluir = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleTelefone.class)
						.excluirTelefone(id))
				.withRel("excluir_telefone");
		objeto.add(linkProprioTelefones);
		objeto.add(linkProprioAtualizar);
		objeto.add(linkProprioExcluir);
	}
}
