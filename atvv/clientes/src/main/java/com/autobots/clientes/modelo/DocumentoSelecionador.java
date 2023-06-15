package com.autobots.clientes.modelo;


import com.autobots.clientes.entidades.Documento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentoSelecionador {

    public Documento selecionar(List<Documento> documentos, long id) {
        Documento selecionado = null;
        for (Documento documento : documentos) {
            if (documento.getId() == id) {
                selecionado = documento;
            }
        }
        return selecionado;
    }
}
