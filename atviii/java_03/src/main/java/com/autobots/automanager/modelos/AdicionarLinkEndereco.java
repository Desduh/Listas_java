package com.autobots.automanager.modelos;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.ControleEndereco;
import com.autobots.automanager.entidades.Endereco;

@Component
public class AdicionarLinkEndereco implements AdicionadorLink<Endereco> {

	@Override
	public void adicionarLink(List<Endereco> lista) {
		for (Endereco endereco : lista) {
			long id = endereco.getId();
			Link linkProprioEndereco = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ControleEndereco.class)
							.obterEndereco(id))
					.withSelfRel();
			endereco.add(linkProprioEndereco);
		}
	}

	@Override
	public void adicionarLink(Endereco objeto) {
		long id = objeto.getId();
		Link linkProprioEnderecos = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleEndereco.class)
						.obterEnderecos())
				.withRel("endereços");
		Link linkProprioAtualizar = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleEndereco.class)
						.atualizarEndereco(objeto))
				.withRel("atualizar_endereço");
		Link linkProprioExcluir = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleEndereco.class)
						.excluirEndereco(id))
				.withRel("excluir_endereço");
		objeto.add(linkProprioEnderecos);
		objeto.add(linkProprioAtualizar);
		objeto.add(linkProprioExcluir);
	}
}