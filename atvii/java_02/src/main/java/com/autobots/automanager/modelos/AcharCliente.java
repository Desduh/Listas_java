package com.autobots.automanager.modelos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Endereco;

@Component
public class AcharCliente {
	private static final Cliente Cliente = null;

	public Cliente porEndereco(List<Cliente> clientes, Endereco endereco) {
		for(Cliente cliente : clientes) {
			if(cliente.getEndereco().getId() == endereco.getId()) {
				return cliente;
			}
		}
		return Cliente;
	}
}
