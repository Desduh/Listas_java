package com.autobots.mercadorias.modelo;


import com.autobots.mercadorias.controles.ServicoControler;
import com.autobots.mercadorias.entidades.Servico;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdicionadorLinkServico implements AdicionadorLink<Servico> {

	@Override
	public void adicionarLink( List<Servico> lista ) {
		for (Servico servico : lista) {
			Link linkServico =  WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ServicoControler.class)
							.buscarPorId(servico.getId()))
					.withSelfRel();
			servico.add(linkServico);

		}
	}
	@Override
	public void adicionarLink( Servico servico ) {
			Link linkServico =  WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ServicoControler.class)
							.buscarTodos())
					.withRel("Todos Serviços");
			servico.add(linkServico);
			
}
}
