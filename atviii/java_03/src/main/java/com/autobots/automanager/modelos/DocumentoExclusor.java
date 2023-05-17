package com.autobots.automanager.modelos;

import java.util.List;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;

public class DocumentoExclusor {
	public List<Cliente> excluir(List<Cliente> clientes, Documento documento) {
		Cliente clienteRe = null;
		int index = -1;
		for(Cliente cliente : clientes) {
			for(Documento documentoCli : cliente.getDocumentos()) {
				if(documentoCli == documento) {
					index = cliente.getDocumentos().indexOf(documento);
					if(index == -1) {
						index = index*-1;
					}
					clienteRe = cliente;
				}
			}
		}
		if(index != -1) {
			clienteRe.getDocumentos().remove(index-1);
		}
		return clientes;
	}
}