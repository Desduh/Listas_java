package com.autobots.automanager.modelos;

import java.util.List;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Telefone;

public class TelefoneAdicionador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();

	public void adicionar(Telefone adicao, Cliente cliente) {
		Telefone telefone = new Telefone();
		if (adicao != null) {
			if (!verificador.verificar(adicao.getDdd())) {
				telefone.setDdd(adicao.getDdd());
			}
			if (!verificador.verificar(adicao.getNumero())) {
				telefone.setNumero(adicao.getNumero());
			}
		}
		cliente.getTelefones().add(telefone);
		
	}

	public void adicionar(Cliente cliente, List<Telefone> adicoes) {
		for (Telefone adicao : adicoes) {
			adicionar(adicao, cliente);
			}
		}
	
	public void adicionar(Cliente cliente, Cliente adicao) {
		adicionar(cliente, adicao.getTelefones());
	}
}
