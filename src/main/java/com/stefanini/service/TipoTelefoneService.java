package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.TipoTelefone;
import com.stefanini.repository.TipoTelefoneRepository;

@Stateless
public class TipoTelefoneService {

    @Inject
    private TipoTelefoneRepository tipoTelefoneRepository;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<TipoTelefone> getTodosTiposTelefone(){
    	return tipoTelefoneRepository.getTodosTiposTelefone();
    }
}
