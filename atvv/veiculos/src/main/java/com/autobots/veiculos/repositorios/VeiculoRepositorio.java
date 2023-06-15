package com.autobots.veiculos.repositorios;


import com.autobots.veiculos.entidades.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long> {

}
