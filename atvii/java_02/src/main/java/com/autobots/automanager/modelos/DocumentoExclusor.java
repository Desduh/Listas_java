package com.autobots.automanager.modelos;

import java.util.List;
import com.autobots.automanager.entidades.Documento;

public class DocumentoExclusor {
	public int excluir(Documento documento, List<Documento> documentos) {
		int index = documentos.indexOf(documento);
		return index;
	}

	public int excluir(List<Documento> documentos, List<Documento> atualizacoes) {
		for (Documento atualizacao : atualizacoes) {
			for (Documento documento : documentos) {
				if (atualizacao.getId() != null) {
					if (atualizacao.getId() == documento.getId()) {
						int index = excluir(documento, documentos);
						return index;
					}
				}
			}
		}
		return -1;
	}
}