package com.autobots.automanager.modelos;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;

public class Exclusor {	
	public void excluirDocumentos(Cliente cliente, Documento documento) {
		DocumentoExclusor exclusor = new DocumentoExclusor();
		int index = exclusor.excluir(cliente.getDocumentos(), documento);
		if(index != -1) {
			cliente.getDocumentos().remove(index);
		}
	}
	public void excluirTelefones(Cliente cliente, Telefone telefone) {
		TelefoneExclusor exclusor = new TelefoneExclusor();
		int index = exclusor.excluir(cliente.getTelefones(), telefone);
		if(index != -1) {
			cliente.getTelefones().remove(index);
		}
	}
	public void excluirEnderecos(Cliente cliente, Endereco endereco) {
		if(endereco != null) {
			cliente.setEndereco(null);	
		}
	}
}
