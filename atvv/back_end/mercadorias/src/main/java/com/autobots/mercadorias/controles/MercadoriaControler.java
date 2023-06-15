package com.autobots.mercadorias.controles;


import com.autobots.mercadorias.entidades.Mercadoria;
import com.autobots.mercadorias.modelo.AdicionadorLinkMercadoria;
import com.autobots.mercadorias.service.MercadoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mercadoria")
public class MercadoriaControler {
	@Autowired
	private MercadoriaService mercadoriaService;
	@Autowired
	private AdicionadorLinkMercadoria adicionadorLinkMercadoria;
	

	
	@GetMapping("/buscar")
	@PreAuthorize("hasAnyAuthority('ROLE_GERENTE') or hasAnyAuthority('ROLE_ADMIN') or hasAnyAuthority('ROLE_VENDEDOR')")
	public ResponseEntity<List<Mercadoria>> buscarTodos(){
		List<Mercadoria> mercadoria = mercadoriaService.findAll();
		if(mercadoria.isEmpty()) {
			return new ResponseEntity<List<Mercadoria>>(HttpStatus.NOT_FOUND);
		}
		adicionadorLinkMercadoria.adicionarLink(mercadoria);
		return new ResponseEntity<List<Mercadoria>>(mercadoria, HttpStatus.FOUND);
	}
	
	@GetMapping("/buscar/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_GERENTE') or hasAnyAuthority('ROLE_ADMIN') or hasAnyAuthority('ROLE_VENDEDOR')")
	public ResponseEntity<Mercadoria> buscarPorId(@PathVariable Long id){
		Mercadoria mercadoria = mercadoriaService.findById(id);
		HttpStatus status = HttpStatus.CONFLICT;
		if(mercadoria == null) {
			status = HttpStatus.NOT_FOUND;	
		}else{
			adicionadorLinkMercadoria.adicionarLink(mercadoria);
			status = HttpStatus.FOUND;
		}
		return new ResponseEntity<Mercadoria>(mercadoria, status);
		
	}

	
}
