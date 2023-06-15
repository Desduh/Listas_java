package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Servico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoControler {




	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/todos-servicos")
	public ResponseEntity<?> obterServicos() {
		List<Servico> servicos = new ArrayList<>();

		ResponseEntity<? extends List> resposta = new RestTemplate()
				.getForEntity("http://localhost:8083/servico/buscar", servicos.getClass());
		servicos = resposta.getBody();

		return new ResponseEntity<List<Servico>>(servicos, HttpStatus.FOUND);
	}


	
}
