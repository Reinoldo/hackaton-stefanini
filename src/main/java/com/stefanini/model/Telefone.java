package com.stefanini.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(TelefoneIdClass.class)
public class Telefone implements Serializable {

	private static final long serialVersionUID = -1886899691540281799L;

	//INICIO IdClass
	@Id
	private Integer numero;
	
	@Id
	private Integer ddd;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cpfProprietario", insertable=false, updatable=false)
	private Proprietario proprietario;
	//FIM IdClass
	
	//INICIO - EmbeddedId
//	@EmbeddedId
//	private TelefoneEmbeddedId id;
//	
//	@ManyToOne
//	@MapsId("cpf")
//	@JoinColumn(name="cpfProprietario", insertable=false, updatable=false)
//	private Proprietario proprietario;
	//FIM - EmbeddedId
	
	@ManyToOne
	@JoinColumn(name="idTipoTelefone")
	private TipoTelefone tipoTelefone;

	public Telefone() {
	}

	public Integer getNumero() {
		return numero; //IdClass
//		return getId().getNumero(); //EmbeddedId
	}

	public void setNumero(Integer numero) {
		this.numero = numero; //IdClass
//		getId().setNumero(numero); //EmbeddedId
	}

	public Integer getDdd() {
		return ddd; //IdClass
//		return getId().getDdd(); //EmbeddedId
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd; //IdClass
//		getId().setDdd(ddd);  //EmbeddedId
	}

	//INICIO - EmbeddedId
//	public TelefoneEmbeddedId getId() {
//		if(id == null) {
//			id = new TelefoneEmbeddedId();
//		}
//		return id;
//	}
//
//	public void setId(TelefoneEmbeddedId id) {
//		this.id = id;
//	}
	//FIM - EmbeddedId

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
}
