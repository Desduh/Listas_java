package com.autobots.automanager.modelos;

import java.util.List;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Telefone;

public class TelefoneExclusor {
	public List<Cliente> excluir(List<Cliente> clientes, Telefone telefone) {
		Cliente clienteRe = null;
		int index = -1;
		for(Cliente cliente : clientes) {
			for(Telefone telefoneCli : cliente.getTelefones()) {
				if(telefoneCli == telefone) {
					index = cliente.getTelefones().indexOf(telefone);
					if(index == -1) {
						index = index*-1;
					}
					clienteRe = cliente;
				}
			}
		}
		if(index != -1) {
			clienteRe.getTelefones().remove(index-1);
		}
		return clientes;
	}
}