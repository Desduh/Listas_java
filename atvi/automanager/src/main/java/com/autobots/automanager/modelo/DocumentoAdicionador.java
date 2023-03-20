package com.autobots.automanager.modelo;

import java.util.List;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;

public class DocumentoAdicionador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();

	public void adicionar(Documento adicao, Cliente cliente) {
		Documento documento = new Documento();
		if (adicao != null) {
			if (!verificador.verificar(adicao.getTipo())) {
				documento.setTipo(adicao.getTipo());
			}
			if (!verificador.verificar(adicao.getNumero())) {
				documento.setNumero(adicao.getNumero());
			}
		}
		cliente.getDocumentos().add(documento);
		
	}

	public void adicionar(Cliente cliente, List<Documento> adicoes) {
		for (Documento adicao : adicoes) {
			adicionar(adicao, cliente);
			}
		}
	
	public void adicionar(Cliente cliente, Cliente adicao) {
		adicionar(cliente, adicao.getDocumentos());
	}
}