package com.contatos.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.contatos.apirest.enums.TelefoneType;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private long id;

	@NotNull
	@ApiModelProperty(required=true)
	private TelefoneType tipo;

	@NotNull
	@ApiModelProperty(required=true)
	private long numero;
	
	public Telefone() {
		
	}
	
	public Telefone(TelefoneType tipo, long numero) {
		this.tipo=tipo;
		this.numero=numero;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TelefoneType getTipo() {
		return tipo;
	}

	public void setTipo(TelefoneType tipo) {
		this.tipo = tipo;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

}
