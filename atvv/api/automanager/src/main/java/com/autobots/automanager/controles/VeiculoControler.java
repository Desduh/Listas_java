package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoControler {



	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/todos-veiculos")
	public ResponseEntity<?> obterVeiculos() {
		List<Veiculo> veiculos = new ArrayList<>();

		ResponseEntity<? extends List> resposta = new RestTemplate()
				.getForEntity("http://localhost:8085/veiculo/buscar", veiculos.getClass());
		veiculos = resposta.getBody();

		return new ResponseEntity<List<Veiculo>>(veiculos, HttpStatus.FOUND);
	}
		
	
}

