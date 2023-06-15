package com.autobots.mercadorias.repositorios;


import com.autobots.mercadorias.entidades.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MercadoriaRepositorio extends JpaRepository<Mercadoria, Long> {

}
