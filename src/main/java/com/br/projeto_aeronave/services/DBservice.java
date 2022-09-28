package com.br.projeto_aeronave.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.projeto_aeronave.domian.Aeronave;
import com.br.projeto_aeronave.repositories.AeronaveRepository;

@Service
public class DBservice {

	@Autowired
	private AeronaveRepository repository;
	
	public void instanciaBaseDeDados() {
		
		Aeronave aero1 = new Aeronave(null, "lorem ipsum", "Embraer", 2014, "E2-190", true);
		Aeronave aero2 = new Aeronave(null, "lorem ipsum", "Boeing",  1998,  "737-100", false);
		Aeronave aero3 = new Aeronave(null, "lorem ipsum", "Embraer", 2015, "KC-390",  false);
		Aeronave aero4 = new Aeronave(null, "lorem ipsum", "Airbus",  1995,  "A320",  true);
		
		repository.saveAll(Arrays.asList(aero1,aero2,aero3,aero4));
	}
	
	
}
