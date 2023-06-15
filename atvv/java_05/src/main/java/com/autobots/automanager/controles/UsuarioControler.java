package com.autobots.automanager.controles;


import com.autobots.automanager.entidades.*;
import com.autobots.automanager.service.EmpresaService;
import com.autobots.automanager.service.UsuarioService;
import com.autobots.automanager.service.VeiculoService;
import com.autobots.automanager.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioControler {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private VeiculoService veiculoService;

	
	@PostMapping("/cadastrar/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_GERENTE') or hasAnyAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario, @PathVariable Long id){
		Empresa empresaSelecionada = empresaService.findById(id);
		
		if(empresaSelecionada != null) {
	        if(usuario.getPerfis().toString().contains("FORNECEDOR")) {
	        	if(usuario.getMercadorias().size() > 0)
	        	empresaSelecionada.getMercadorias().addAll(usuario.getMercadorias());
	        }	
	        
	        usuarioService.create(usuario);
	        
	        empresaSelecionada.getUsuarios().add(usuario);
	        empresaService.create(empresaSelecionada);

	        return new ResponseEntity<> (HttpStatus.CREATED);
	        
		}
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        	
	}
	
	
	@GetMapping("/buscar")
	@PreAuthorize("hasAnyAuthority('ROLE_GERENTE') or hasAnyAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<Usuario>> pegarTodos(){
		List<Usuario> usuario = usuarioService.findAll();
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.FOUND);
	}
	
	@GetMapping("/buscar/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_GERENTE') or hasAnyAuthority('ROLE_ADMIN') or hasAnyAuthority('ROLE_CLIENTE')")
	public ResponseEntity<Usuario> pegarUm(@PathVariable Long id){
		Usuario usuario = usuarioService.findById(id);
		HttpStatus status = HttpStatus.CONFLICT;
		if(usuario == null) {
			status = HttpStatus.NOT_FOUND;	
		}else{
			status = HttpStatus.FOUND;
		}
		return new ResponseEntity<Usuario>(usuario, status);
	}
	
	@PutMapping("/cadastrar-credencial/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_GERENTE') or hasAnyAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> cadastroCredencial(@PathVariable Long id, @RequestBody CredencialUsuarioSenha credencialUsuario){
		Usuario usuario = usuarioService.findById(id);
		if(usuario == null) {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		usuario.getCredenciais().add(credencialUsuario);
		usuarioService.create(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/deletar/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Usuario usuarioSelecionado = usuarioService.findById(id);
		if (usuarioSelecionado == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		for (Empresa empresa : empresaService.findAll()) {
			for(Usuario funcionario : empresa.getUsuarios()) {
				if(funcionario.getId() == usuarioSelecionado.getId()) {
					empresa.getUsuarios().remove(funcionario);
				}
			}
		}
		
		 for(Venda venda : vendaService.findAll()) {
			 if(venda.getFuncionario().getId() == usuarioSelecionado.getId()) {
				 venda.setFuncionario(null);
			 }
			 if(venda.getCliente().getId() == usuarioSelecionado.getId()) {
				 venda.setCliente(null);
			 }
		 }
		
		for (Veiculo veiculo : veiculoService.findAll()) {
			if(veiculo.getProprietario().getId() == usuarioSelecionado.getId()) {
				veiculo.setProprietario(null);
			}
		}
		
		usuarioSelecionado.getDocumentos().removeAll(usuarioSelecionado.getDocumentos());
		usuarioSelecionado.getTelefones().removeAll(usuarioSelecionado.getTelefones());
		usuarioSelecionado.getEmails().removeAll(usuarioSelecionado.getEmails());
		usuarioSelecionado.getCredenciais().removeAll(usuarioSelecionado.getCredenciais());
		usuarioSelecionado.getMercadorias().removeAll(usuarioSelecionado.getMercadorias());
		usuarioSelecionado.getVeiculos().removeAll(usuarioSelecionado.getVeiculos());
		usuarioSelecionado.getVendas().removeAll(usuarioSelecionado.getVendas());
		usuarioSelecionado.setEndereco(null);
		
		
		usuarioService.delete(usuarioSelecionado);
		
		return new ResponseEntity<>(HttpStatus.OK);
			
		}

}
