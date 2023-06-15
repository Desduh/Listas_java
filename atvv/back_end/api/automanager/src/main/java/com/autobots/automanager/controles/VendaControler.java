package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Venda;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/venda")

public class VendaControler {


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/todas-vendas")
	public ResponseEntity<?> obterVendas() {
		List<Venda> vendas = new ArrayList<>();

		ResponseEntity<? extends List> resposta = new RestTemplate()
				.getForEntity("http://localhost:8084/venda/buscar", vendas.getClass());
		vendas = resposta.getBody();

		return new ResponseEntity<List<Venda>>(vendas, HttpStatus.FOUND);
	}

	
	
}
