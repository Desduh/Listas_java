package com.autobots.clientes.modelo;


import com.autobots.clientes.entidades.Telefone;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TelefoneSelecionador {

    public Telefone selecionar(List<Telefone> telefones, long id) {
        Telefone selecionado = null;
        for (Telefone telefone : telefones) {
            if (telefone.getId() == id) {
                selecionado = telefone;
            }
        }
        return selecionado;
    }
}
