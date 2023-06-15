package com.autobots.mercadorias.controles;


import com.autobots.mercadorias.entidades.Servico;
import com.autobots.mercadorias.modelo.AdicionadorLinkServico;
import com.autobots.mercadorias.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoControler {

	@Autowired
	private ServicoService servicoService;


	
	@Autowired
	private AdicionadorLinkServico adicionadorLinkServico;
	

	
	@GetMapping("/buscar")
	public ResponseEntity<List<Servico>> buscarTodos(){
		List<Servico> servicos = servicoService.findAll();
		adicionadorLinkServico.adicionarLink(servicos);
		return new ResponseEntity<List<Servico>>(servicos, HttpStatus.FOUND);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Servico> buscarPorId(@PathVariable Long id){
		Servico servico = servicoService.findById(id);
		HttpStatus status = HttpStatus.CONFLICT;
		if(servico == null) {
			status = HttpStatus.NOT_FOUND;
		}else{
			adicionadorLinkServico.adicionarLink(servico);
			status = HttpStatus.FOUND;
		}
		return new ResponseEntity<Servico>(servico, status);
	}


	
}
