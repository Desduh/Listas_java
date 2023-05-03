package com.autobots.automanager.modelos;

import java.util.List;

import com.autobots.automanager.entidades.Telefone;

public class TelefoneExclusor {
	public int excluir(Telefone telefone, List<Telefone> telefones) {
		int index = telefones.indexOf(telefone);
		return index;
	}

	public int excluir(List<Telefone> telefones, List<Telefone> atualizacoes) {
		for (Telefone atualizacao : atualizacoes) {
			for (Telefone telefone : telefones) {
				if (atualizacao.getId() != null) {
					if (atualizacao.getId() == telefone.getId()) {
						int index = excluir(telefone, telefones);
						return index;
					}
				}
			}
		}
		return -1;
	}
}
