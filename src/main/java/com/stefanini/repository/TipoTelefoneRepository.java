package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.TipoTelefone;

public class TipoTelefoneRepository {

	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<TipoTelefone> getTodosTiposTelefone() {
		return manager.createQuery("select tt from TipoTelefone tt").getResultList();
	}
}
