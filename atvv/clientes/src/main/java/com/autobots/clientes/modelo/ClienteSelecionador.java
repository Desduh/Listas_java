package com.autobots.clientes.modelo;

import java.util.List;

import com.autobots.clientes.entidades.Cliente;
import org.springframework.stereotype.Component;


@Component
public class ClienteSelecionador {
	public Cliente selecionar(List<Cliente> clientes, long id) {
		Cliente selecionado = null;
		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				selecionado = cliente;
			}
		}
		return selecionado;
	}
}