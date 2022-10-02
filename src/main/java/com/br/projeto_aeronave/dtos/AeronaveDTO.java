package com.br.projeto_aeronave.dtos;
import java.io.Serializable;
import java.util.Date;
import org.hibernate.validator.constraints.Length;
import com.br.projeto_aeronave.domian.Aeronave;

public class AeronaveDTO implements Serializable {

	private static final long serialVersionUID = 1L;

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
