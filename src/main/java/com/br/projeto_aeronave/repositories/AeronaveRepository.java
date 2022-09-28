package com.br.projeto_aeronave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.projeto_aeronave.domian.Aeronave;

public interface AeronaveRepository extends JpaRepository<Aeronave, Long>{

}
