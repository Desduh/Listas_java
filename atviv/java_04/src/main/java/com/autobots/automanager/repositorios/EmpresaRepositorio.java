package com.autobots.automanager.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.automanager.entitades.Empresa;


public interface EmpresaRepositorio extends JpaRepository<Empresa, Long>{

}
