package dev.acosta.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message="O CEP deve ser informado.")
	@NotEmpty(message="O campo de CEP não pode estar vazio.")
	private String cep;
	@NotNull(message="O nome da rua deve ser informado.")
	@NotEmpty(message="O campo de nome da rua não pode estar vazio.")
	private String rua;
	@NotNull(message="O número deve ser informado.")
	@NotEmpty(message="O número não pode estar vazio.")
	private Integer numero;
	private String complemento;
	@NotNull(message="O bairro deve ser informado.")
	@NotEmpty(message="O nome do bairro não pode estar vazio.")
	private String bairro;
	@NotNull(message="A cidade deve ser informada.")
	@NotEmpty(message="O nome da cidade não pode estar vazio.")
	private String cidade;
	@NotNull(message="O Estado deve ser informado.")
	@NotEmpty(message="O Estado não pode estar vazio.")
	private String estado;
	
	@ManyToOne
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
