package com.autobots.automanager.modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.ControleDocumento;
import com.autobots.automanager.controles.ControleEndereco;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@Component
public class AdicionadorLinkDocumentos implements AdicionadorLink<Documento> {

	@Override
	public void adicionarLink(List<Documento> lista) {
		for (Documento documento : lista) {
			long id = documento.getId();
			Link linkProprioDocumento = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ControleDocumento.class)
							.obterDocumento(id))
					.withSelfRel();
			documento.add(linkProprioDocumento);
		}
	}

	@Override
	public void adicionarLink(Documento objeto) {
		long id = objeto.getId();
		Link linkProprioDocumentos = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleDocumento.class)
						.obterDocumentos())
				.withRel("documentos");
		Link linkProprioAtualizar = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleDocumento.class)
						.atualizarDocumento(objeto))
				.withRel("atualizar_documento");
		Link linkProprioExcluir = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ControleDocumento.class)
						.excluirDocumento(id))
				.withRel("excluir_documento");
		objeto.add(linkProprioDocumentos);
		objeto.add(linkProprioAtualizar);
		objeto.add(linkProprioExcluir);
	}
}
