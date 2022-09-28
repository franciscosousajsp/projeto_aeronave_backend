package com.br.projeto_aeronave.domian;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.br.projeto_aeronave.dtos.AeronaveDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Aeronave implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String marca;
	private Integer ano;
	private String descricao;
	private Boolean vendido;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate created = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate update = LocalDate.now();

	public Aeronave() {
		super();
	}

	public Aeronave(Long id, String nome, String marca, Integer ano, String descricao, Boolean vendido) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
	}

	public Aeronave(AeronaveDTO objDTO) {
		super();
		
		this.id = objDTO.getId();
		this.nome = objDTO.getNome();
		this.marca = objDTO.getMarca();
		this.ano = objDTO.getAno();
		this.descricao = objDTO.getDescricao();
		this.vendido = objDTO.getVendido();
		this.update = null;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getVendido() {
		return vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public LocalDate getUpdate() {
		return update;
	}

	public void setUpdate(LocalDate update) {
		this.update = update;
	}
	
	
	
	
}
