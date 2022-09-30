package com.br.projeto_aeronave.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.br.projeto_aeronave.domian.Aeronave;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AeronaveDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	@NotEmpty(message = "Campo Marca é requerido")
	@Length(min = 3, max = 50, message = "o campo Marca deve ter entre 3 e 50 caracteres")
	private String marca;
	
	private Integer ano;
	@NotEmpty(message = "Campo Modelo é requerido")
	@Length(min = 3, max = 50, message = "o campo Modelo deve ter entre 3 e 50 caracteres")
	private String descricao;
	private Boolean vendido;
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate created = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate update = LocalDate.now();
	
	public AeronaveDTO() {
		super();
		
	}

	public AeronaveDTO(Aeronave obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.marca = obj.getMarca();
		this.ano = obj.getAno();
		this.descricao = obj.getDescricao();
		this.vendido = obj.getVendido();
		this.created = obj.getCreated();
		this.update = obj.getUpdate();
		
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
