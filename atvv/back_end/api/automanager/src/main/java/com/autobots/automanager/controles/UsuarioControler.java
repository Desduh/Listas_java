package com.autobots.automanager.controles;


import com.autobots.automanager.entidades.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioControler {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/todos-usuarios")
	public ResponseEntity<?> obterUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();

		ResponseEntity<? extends List> resposta = new RestTemplate()
				.getForEntity("http://localhost:8082/usuario/buscar", usuarios.getClass());
		usuarios = resposta.getBody();

		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.FOUND);
	}

}
