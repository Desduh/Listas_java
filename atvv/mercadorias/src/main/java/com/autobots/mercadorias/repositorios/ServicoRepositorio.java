package com.autobots.mercadorias.repositorios;


import com.autobots.mercadorias.entidades.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepositorio extends JpaRepository<Servico, Long> {

}
