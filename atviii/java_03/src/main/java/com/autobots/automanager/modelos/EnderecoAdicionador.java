package com.autobots.automanager.modelos;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Endereco;

public class EnderecoAdicionador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();

	public void adicionar(Endereco adicao, Cliente cliente) {
		Endereco endereco = new Endereco();
		if (adicao != null) {
			if (!verificador.verificar(adicao.getEstado())) {
				endereco.setEstado(adicao.getEstado());
			}
			if (!verificador.verificar(adicao.getCidade())) {
				endereco.setCidade(adicao.getCidade());
			}
			if (!verificador.verificar(adicao.getBairro())) {
				endereco.setBairro(adicao.getBairro());
			}
			if (!verificador.verificar(adicao.getRua())) {
				endereco.setRua(adicao.getRua());
			}
			if (!verificador.verificar(adicao.getNumero())) {
				endereco.setNumero(adicao.getNumero());
			}
			if (!verificador.verificar(adicao.getCodigoPostal())) {
				endereco.setCodigoPostal(adicao.getCodigoPostal());
			}
			if (!verificador.verificar(adicao.getInformacoesAdicionais())) {
				endereco.setInformacoesAdicionais(adicao.getInformacoesAdicionais());
			}
			cliente.setEndereco(endereco);
		}		
	}

	public void adicionar(Cliente cliente, Endereco adicao) {
		if(cliente.getEndereco() == null) {
			adicionar(adicao, cliente);
		}
	}
	
	public void adicionar(Cliente cliente, Cliente adicao) {
		adicionar(cliente, adicao.getEndereco());
	}
}
