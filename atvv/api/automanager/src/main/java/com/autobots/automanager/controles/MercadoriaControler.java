package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Mercadoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mercadoria")
public class MercadoriaControler {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/todas-mercadorias")
	public ResponseEntity<?> obterMercadorias() {
		List<Mercadoria> mercadorias = new ArrayList<>();

		ResponseEntity<? extends List> resposta = new RestTemplate()
				.getForEntity("http://localhost:8083/mercadoria/buscar", mercadorias.getClass());
		mercadorias = resposta.getBody();

		return new ResponseEntity<List<Mercadoria>>(mercadorias, HttpStatus.FOUND);
	}

	
}
