package com.autobots.automanager.modelos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.ControleDocumento;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@Component
public class AdicionadorLinkDocumentos implements AdicionadorLink<Documento> {
	@Autowired
	private ClienteRepositorio repositorioCliente;
	@Override
	public void adicionarLink(List<Documento> lista) {
		List<Cliente> clientes = repositorioCliente.findAll();
		for (Documento documento : lista) {
			for (Cliente cliente : clientes) {
				for (Documento cli_doc : cliente.getDocumentos()) {
					if(cli_doc.getId() == documento.getId()) {
						Link linkProprio = WebMvcLinkBuilder
								.linkTo(WebMvcLinkBuilder
										.methodOn(ControleDocumento.class)
										.excluirDocumento(documento.getId(),cliente.getId()))
								.withRel("Excluir documento");
						documento.add(linkProprio);
					}
				}
			}
		}
	}

	@Override
	public void adicionarLink(Documento objeto) {
		// TODO Auto-generated method stub
		
	}
}
