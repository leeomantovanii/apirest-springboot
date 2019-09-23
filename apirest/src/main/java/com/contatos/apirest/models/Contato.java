package com.contatos.apirest.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private long id;

	@NotNull @NotBlank
	@ApiModelProperty(required=true)
	private String nome;
	
	@NotNull 
	@ApiModelProperty(required=true)
	private Date dtNascimento;
	
	private boolean favorito;

	@OneToMany(targetEntity = Telefone.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_contato")
	@NotNull 
	@ApiModelProperty(required=true)
	private List<Telefone> telefones;

	@OneToMany(targetEntity = Email.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_contato")
	@NotNull 
	@ApiModelProperty(required=true)
	private List<Email> emails;

	public Contato() {
		setTelefones(new ArrayList<>());
		setEmails(new ArrayList<>());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public boolean getFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

}
