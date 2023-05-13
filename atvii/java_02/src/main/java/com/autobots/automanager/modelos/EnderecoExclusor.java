package com.autobots.automanager.modelos;

import java.util.List;
import com.autobots.automanager.entidades.Cliente;

public class EnderecoExclusor {	
	public List<Cliente> excluirEndereco(long id, List<Cliente> clientes) {
		for(Cliente cliente : clientes) {
			if(cliente.getEndereco() != null) {
				if(cliente.getEndereco().getId() == id) {
					cliente.setEndereco(null);	
				}
			}
		}
		return clientes;
	}
}
