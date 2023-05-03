package com.autobots.automanager.modelo;

import java.util.List;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;

public class Exclusor {	
	public void excluirDocumentos(Cliente cliente, List<Documento> documentos) {
		DocumentoExclusor exclusor = new DocumentoExclusor();
		int index = exclusor.excluir(cliente.getDocumentos(), documentos);
		if(index != -1) {
			cliente.getDocumentos().remove(index);
		}
	}
	public void excluirTelefones(Cliente cliente, List<Telefone> telefones) {
		TelefoneExclusor exclusor = new TelefoneExclusor();
		int index = exclusor.excluir(cliente.getTelefones(), telefones);
		if(index != -1) {
			cliente.getTelefones().remove(index);
		}
	}
	public void excluirEnderecos(Cliente cliente, Endereco endereco) {
		if(endereco != null) {
			cliente.setEndereco(null);	
		}
	}
	
	public void excluir(Cliente cliente, Cliente exclusao) {
		excluirDocumentos(cliente, exclusao.getDocumentos());
		excluirTelefones(cliente, exclusao.getTelefones());
		excluirEnderecos(cliente, exclusao.getEndereco());
	}
}
