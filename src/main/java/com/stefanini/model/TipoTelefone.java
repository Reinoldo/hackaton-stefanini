package com.stefanini.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoTelefone implements Serializable{


	private static final long serialVersionUID = 2336625362717613046L;

	@Id
	private Integer idTipoTelefone;
	
	private String descricaoTipoTelefone;

	public Integer getId() {
		return idTipoTelefone;
	}

	public void setId(Integer idTipoTelefone) {
		this.idTipoTelefone = idTipoTelefone;
	}

	public String getDescricaoTipoTelefone() {
		return descricaoTipoTelefone;
	}

	public void setDescricao(String descricaoTipoTelefone) {
		this.descricaoTipoTelefone = descricaoTipoTelefone;
	}
	
	
}
