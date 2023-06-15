package com.autobots.automanager.repositorios;

import com.autobots.automanager.entidades.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepositorio extends JpaRepository<Email, Long> {

}
