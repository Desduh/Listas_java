package com.autobots.funcionarios.controles;

import com.autobots.funcionarios.entidades.Usuario;

import com.autobots.funcionarios.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioControler {

	@Autowired
	private UsuarioService usuarioService;

	
	@GetMapping("/buscar")
	public ResponseEntity<List<Usuario>> buscarTodos(){
		List<Usuario> usuario = usuarioService.findAll();
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.FOUND);
	}
	


}
