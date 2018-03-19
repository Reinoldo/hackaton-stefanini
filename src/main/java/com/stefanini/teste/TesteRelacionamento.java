package com.stefanini.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Telefone;
import com.stefanini.model.TelefonePK;
import com.stefanini.util.EntityManagerProducer;

public class TesteRelacionamento {

	public static void main(String[] args) {
		
		EntityManagerProducer emp = new  EntityManagerProducer();
		
		EntityManager em =  emp.getEntityManager();

		TelefonePK telPk = new TelefonePK();
		Telefone tel = new Telefone();
		Proprietario pro = new Proprietario();
		
		telPk.setDdd(61);
		telPk.setNumero(98765);
		pro.setCpfProprietario(1l);
		pro.setNome("reinoldo");
		
	
		
		
		
		
		
		em.getTransaction().begin();
		em.persist(pro);
		em.persist(tel);
		em.getTransaction().commit();
	}

}
