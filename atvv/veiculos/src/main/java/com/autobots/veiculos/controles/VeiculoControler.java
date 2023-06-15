package com.autobots.veiculos.controles;




import com.autobots.veiculos.entidades.Veiculo;
import com.autobots.veiculos.modelo.AdicionadorLinkVeiculo;
import com.autobots.veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoControler {
	
	@Autowired
	private VeiculoService veiculoService;

	@Autowired
	private AdicionadorLinkVeiculo adicionadorLinkVeiculo;
	

	
	@GetMapping("/buscar")
	public ResponseEntity<List<Veiculo>> buscarTodos(){
		List<Veiculo> veiculo = veiculoService.findAll();
		adicionadorLinkVeiculo.adicionarLink(veiculo);
		return new ResponseEntity<List<Veiculo>>(veiculo, HttpStatus.FOUND);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id){
		Veiculo veiculo = veiculoService.findById(id);
		HttpStatus status = HttpStatus.CONFLICT;
		if(veiculo == null) {
			status = HttpStatus.NOT_FOUND;	
		}else{
			adicionadorLinkVeiculo.adicionarLink(veiculo);
			status = HttpStatus.FOUND;
		}
		return new ResponseEntity<Veiculo>(veiculo, status);
	}

		
	
}

