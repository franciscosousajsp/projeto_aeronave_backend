package com.br.projeto_aeronave.domian;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Length;
import com.br.projeto_aeronave.dtos.AeronaveDTO;


@Entity
public class Aeronave implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Length(min = 3, max = 50, message = "o campo Marca deve ter entre 3 e 50 caracteres")
	private String marca;
	private Integer ano;
	
	@Length(min = 3, max = 50, message = "o campo Modelo deve ter entre 3 e 50 caracteres")
	private String descricao;
	private Boolean vendido;
	
	
	protected Date created = new Date();
	protected Date update = new Date();

	public Aeronave() {
		super();
	}

	public Aeronave(Long id, String nome, String marca, Integer ano, String descricao, Boolean vendido, Date created) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
		this.created = created;
	}

	public Aeronave(AeronaveDTO objDTO) {
		super();
		
		this.id = objDTO.getId();
		this.nome = objDTO.getNome();
		this.marca = objDTO.getMarca();
		this.ano = objDTO.getAno();
		this.descricao = objDTO.getDescricao();
		this.vendido = objDTO.getVendido();
		this.created = objDTO.getCreated();
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	
	
	
	
	
}
