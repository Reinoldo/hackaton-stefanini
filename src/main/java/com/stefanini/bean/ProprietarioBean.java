package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Telefone;
import com.stefanini.model.TipoTelefone;
import com.stefanini.service.ProprietarioService;
import com.stefanini.service.TipoTelefoneService;

@Named("proprietarioMB")
@SessionScoped
public class ProprietarioBean implements Serializable {

	private static final long serialVersionUID = -2157009794256537118L;

	@Inject
	private ProprietarioService proprietarioService;

	@Inject
	private TipoTelefoneService tipoTelefoneService;
	
	@Inject
	private Proprietario proprietario;
	
	@Inject
	private Telefone telefone;
	
	private List<Proprietario> proprietarios;
	
	private List<TipoTelefone> tiposTelefone;
	private boolean novoProprietario = false;


	@PostConstruct
	public void init() {
		setTiposTelefone(tipoTelefoneService.getTodosTiposTelefone());
		proprietarios =  proprietarioService.listaTodos();
	}
	



	

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	public String novoProprietario() {
		novoProprietario = true;
	
		setProprietario(new Proprietario());
		setTelefone(new Telefone());
		
		return "/proprietario/adicionarProprietario.xhtml?faces-redirect=true";
	}
	public String exibirCadastroProprietario(){
		
		return "/proprietario/adicionarProprietario.xhtml?faces-redirect=true";
	}
	
	public String exibirProprietario(){
		novoProprietario = false;
		Proprietario p = proprietarioService.buscar(proprietario);
		setProprietario(p);
		setTelefone(new Telefone());
		return "/proprietario/adicionarProprietario.xhtml?faces-redirect=true";
	}

	public void chamar() {

		Proprietario proprietario2 = proprietarioService.buscar(getProprietario());
		System.out.println(proprietario2);

	}

	public List<Proprietario> listaTodos() {
		List<Proprietario> lista = proprietarioService.listaTodos();
		return lista;
	}

	public String adicionarProprietario() {
		proprietarioService.buscar(this.proprietario);
		
		if (proprietarioService.buscar(this.proprietario)== null) {
			proprietarioService.adicionar(getProprietario());

		} else {

			proprietarioService.editar(getProprietario());
		}
		proprietarios = proprietarioService.listaTodos();
		return "/proprietario/listarProprietario.xhtml?faces-redirect=true";

	}

	public void remover(Proprietario p) {
		try {
			proprietarioService.remover(p);
			proprietarios = proprietarioService.listaTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public String editarProprietario(Proprietario p){
		this.proprietario = p;
		 return "/proprietario/adicionarProprietario.xhtml?faces-redirect=true";
	}
	
	
	
	public List<Proprietario> getProprietarios() {
		return proprietarios;
	}



	public void setProprietarios(List<Proprietario> proprietarios) {
		this.proprietarios = proprietarios;
	}

	
	//=======================  Métodos relacionados com TELEFONE =======================================
	
	


	public Telefone getTelefone() {
		return telefone;
	}

	public void editarTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	public void adicionarTelefone() {
		Proprietario p = getProprietario();
		
		if(getTelefone().getDdd() == null || getTelefone().getNumero() == null) {
			return;
		}
		
		if(p.getTelefones() == null) {
			p.setTelefones(new ArrayList<Telefone>());
		}
		
		if(!p.getTelefones().contains(getTelefone())) {
			p.getTelefones().add(getTelefone());
		}
		
		setTelefone(new Telefone());
	}
	
	public void excluirTelefone(Telefone telefone) {
		getProprietario().getTelefones().remove(telefone);
	}



	public List<TipoTelefone> getTiposTelefone() {
		return tiposTelefone;
	}



	public void setTiposTelefone(List<TipoTelefone> tiposTelefone) {
		this.tiposTelefone = tiposTelefone;
	}

	

}
