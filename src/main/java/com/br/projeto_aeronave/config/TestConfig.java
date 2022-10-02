package com.br.projeto_aeronave.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.br.projeto_aeronave.services.DBservice;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBservice dbService;
	
	@Bean
	public void instanciaBaseDeDados() throws ParseException {
		this.dbService.instanciaBaseDeDados();
	}
	
	

}
