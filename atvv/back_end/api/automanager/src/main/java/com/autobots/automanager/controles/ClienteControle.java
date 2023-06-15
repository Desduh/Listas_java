package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteControle {



	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/todos-clientes")
	public ResponseEntity<?> obterClientes() {
		List<Cliente> clientes = new ArrayList<>();

		ResponseEntity<? extends List> resposta = new RestTemplate()
				.getForEntity("http://localhost:8081/cliente/clientes", clientes.getClass());
		clientes = resposta.getBody();

		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.FOUND);
	}


}
