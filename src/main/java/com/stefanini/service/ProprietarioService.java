package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Proprietario;
import com.stefanini.repository.ProprietarioRepository;

@Stateless
public class ProprietarioService {

    @Inject
    private ProprietarioRepository proprietarioRepository;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Proprietario buscar(Proprietario proprietario){
    	return proprietarioRepository.buscar(proprietario);
    }
    
    
    
    public void adicionar(Proprietario proprietario){
    	proprietarioRepository.adicionar(proprietario);
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Proprietario> listaTodos(){
    	return proprietarioRepository.listaTodos();
    	
    }
    
    public void remover(Proprietario p){
    	proprietarioRepository.remover(p);
    }
    
    public void editar(Proprietario p){
    	proprietarioRepository.editar(p);
    }
}
