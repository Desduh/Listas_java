package com.autobots.automanager.controles;

import com.autobots.automanager.adicionadorLinks.AdicionadorLinkServico;
import com.autobots.automanager.entidades.Empresa;
import com.autobots.automanager.entidades.Servico;
import com.autobots.automanager.entidades.Venda;
import com.autobots.automanager.service.EmpresaService;
import com.autobots.automanager.service.ServicoService;
import com.autobots.automanager.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoControler {

	@Autowired
	private ServicoService servicoService;

	@Autowired
	private VendaService vendaService;

	@Autowired
	EmpresaService empresaService;
	
	@Autowired
	private AdicionadorLinkServico adicionadorLinkServico;
	
	@PutMapping("/atualizar/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_GERENTE') or hasAnyAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> atualizar(@RequestBody Servico servico , @PathVariable Long id){
		Servico serv = servicoService.findById(id);
		if(serv == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		servico.setId(id);
		servicoService.update(servico);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/cadastrar/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_GERENTE') or hasAnyAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> cadastrar(@RequestBody Servico servico, @PathVariable Long id ){
	Empresa empresa = empresaService.findById(id);
	if (empresa == null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	empresa.getServicos().add(servico);
	empresaService.create(empresa);
	return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/buscar")
	@PreAuthorize("hasAnyAuthority('ROLE_GERENTE') or hasAnyAuthority('ROLE_ADMIN') or hasAnyAuthority('ROLE_VENDEDOR')")
	public ResponseEntity<List<Servico>> buscarTodos(){
		List<Servico> servicos = servicoService.findAll();
		adicionadorLinkServico.adicionarLink(servicos);
		return new ResponseEntity<List<Servico>>(servicos, HttpStatus.FOUND);
	}
	
	@GetMapping("/buscar/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_GERENTE') or hasAnyAuthority('ROLE_ADMIN') or hasAnyAuthority('ROLE_VENDEDOR')")
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
	
	@DeleteMapping("/deletar/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_GERENTE') or hasAnyAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Servico servicoSelecionado = servicoService.findById(id);
		
		if(servicoSelecionado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<Empresa> empresas = empresaService.findAll();
	    List<Venda> vendas = vendaService.findAll();
	    
	    for (Empresa empresa : empresas) {
	        for (Servico servico : empresa.getServicos()) {
	          if (servico.getId().equals(id)) {
	        	  empresa.getServicos().remove(servico);
	          }
	        }
	      }
	    
	      for (Venda venda : vendas) {
	        for (Servico servico : venda.getServicos()) {
	          if (servico.getId().equals(id)) {
	        	  venda.getServicos().remove(servico);
	          }
	        }
	      }
	
	    servicoService.delete(servicoSelecionado);
		return new ResponseEntity<>(HttpStatus.OK);
	    
	}
	
}
