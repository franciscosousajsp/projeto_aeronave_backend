package com.br.projeto_aeronave.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.projeto_aeronave.domian.Aeronave;
import com.br.projeto_aeronave.repositories.AeronaveRepository;

@Service
public class DBservice {

	@Autowired
	private AeronaveRepository repository;
	
	public void instanciaBaseDeDados() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Aeronave aero1 = new Aeronave(null, "lorem ipsum", "Embraer", 2014, "E2-190", true, sdf.parse("2022-10-02 18:33:25"));
		Aeronave aero2 = new Aeronave(null, "lorem ipsum", "Boeing",  1998,  "737-100", false,sdf.parse("2022-08-01 16:13:25"));
		Aeronave aero3 = new Aeronave(null, "lorem ipsum", "Embraer", 2015, "KC-390",  false, sdf.parse("2022-08-07 14:35:25"));
		Aeronave aero4 = new Aeronave(null, "lorem ipsum", "Airbus",  1995,  "A320",  true, sdf.parse("2022-04-29 13:20:25"));
		
		repository.saveAll(Arrays.asList(aero1,aero2,aero3,aero4));
	}
	
	
}
