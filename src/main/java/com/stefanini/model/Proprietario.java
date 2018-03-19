package com.stefanini.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Proprietario implements Serializable {

	private static final long serialVersionUID = 186586564095030146L;

	@Id
    private Long cpfProprietario;
    
	private String nome;
	private String endereco;
	private String bairro;
	private String cidade;	
	private String uf;
	private String sexo;
	
	@Column(name="dtNascimento")
	private Date dataNascimento;
	
	@ElementCollection
	@OneToMany(cascade=CascadeType.ALL,mappedBy="proprietario", targetEntity=Telefone.class,orphanRemoval=true, fetch=FetchType.EAGER)
	private List<Telefone> telefones;
	
	
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Long getCpfProprietario() {
		return cpfProprietario;
	}

	public void setCpfProprietario(Long cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
