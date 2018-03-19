package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Telefone;

public class ProprietarioRepository {

	@Inject
	private EntityManager manager;
	
	public Proprietario buscar(Proprietario proprietario) {
		
		return this.manager.find(Proprietario.class, proprietario.getCpfProprietario());
	}
	
	public void adicionar(Proprietario proprietario) {
		List<Telefone> list = proprietario.getTelefones();
		
		if(list != null) {
			for (Telefone telefone : list) {
				telefone.setProprietario(proprietario);
			}
		}
		
		this.manager.persist(proprietario);
	}
	
	@SuppressWarnings("unchecked")
	public List<Proprietario> listaTodos(){		
		return this.manager.createQuery("select p from Proprietario p").getResultList();
	}
	
	public void remover(Proprietario p){
		this.manager.remove(manager.merge(p));
	
	}
	
	public void editar(Proprietario proprietario) {
		Proprietario p = buscar(proprietario);
		
		//p.getTelefones().clear();
		
		this.manager.flush();
		
		List<Telefone> list = proprietario.getTelefones();
		
		if(list != null) {
			for (Telefone telefone : list) {
				telefone.setProprietario(p);
			}
		}
		
		p.setTelefones(proprietario.getTelefones());	
		
		p.setNome(proprietario.getNome());
		
		this.manager.merge(p);
	}
}




