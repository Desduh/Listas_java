package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.adicionadorLinks.AdicionadorLinkEmpresa;
import com.autobots.automanager.atualizadores.EmpresaAtualizador;
import com.autobots.automanager.entitades.Empresa;
import com.autobots.automanager.modelo.Selecionador;
import com.autobots.automanager.repositorios.EmpresaRepositorio;

@RestController
@RequestMapping("/empresa")
public class EmpresaControle {
	@Autowired
	private EmpresaRepositorio repositorio;
	@Autowired
	private AdicionadorLinkEmpresa adicionadorLink;

	@GetMapping("/{id}")
	public ResponseEntity<Empresa> obterEmpresa(@PathVariable long id) {
		List<Empresa> empresas = repositorio.findAll();
		Empresa empresa = Selecionador.empresaSelecionador(empresas, id);
		if (empresa == null) {
			ResponseEntity<Empresa> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(empresas);
			ResponseEntity<Empresa> resposta = new ResponseEntity<Empresa>(empresa, HttpStatus.FOUND);
			return resposta;
		}
	}

	@GetMapping("/visualizar")
	public ResponseEntity<List<Empresa>> obterEmpresas() {
		List<Empresa> empresas = repositorio.findAll();
		if (empresas.isEmpty()) {
			ResponseEntity<List<Empresa>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(empresas);
			ResponseEntity<List<Empresa>> resposta = new ResponseEntity<>(empresas, HttpStatus.FOUND);
			return resposta;
		}
	}

	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrarEmpresa(@RequestBody Empresa empresa) {
		HttpStatus status = HttpStatus.CONFLICT;
		if (empresa.getId() == null) {
			repositorio.save(empresa);
			status = HttpStatus.CREATED;
		}
		return new ResponseEntity<>(status);
	}

	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizarEmpresa(@RequestBody Empresa atualizacao) {
		HttpStatus status = HttpStatus.CONFLICT;
		Empresa empresa = repositorio.getById(atualizacao.getId());
		if (empresa != null) {
			EmpresaAtualizador atualizador = new EmpresaAtualizador();
			atualizador.atualizar(empresa, atualizacao);
			repositorio.save(empresa);
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(status);
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<?> excluirEmpresa(@PathVariable long id) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Empresa empresa = repositorio.getById(id);
		if (empresa != null) {
			repositorio.delete(empresa);
			status = HttpStatus.OK;
		}
		return new ResponseEntity<>(status);
	}
}