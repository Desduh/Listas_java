package com.autobots.pecas.repositorios;


import com.autobots.pecas.entidades.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepositorio extends JpaRepository<Venda,Long > {

}
