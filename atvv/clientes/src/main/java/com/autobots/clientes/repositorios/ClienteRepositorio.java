package com.autobots.clientes.repositorios;

import com.autobots.clientes.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}