package com.monix.work.dao;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.monix.work.entities.Client;
import com.monix.work.entities.Compte;
import com.monix.work.entities.Employe;
import com.monix.work.entities.Groupe;
import com.monix.work.entities.Operation;

public class BanqueDaoImpl implements IBanqueDao{

	
	@PersistenceContext
	private EntityManager em;
	@Override
	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}

	@Override
	public Employe addEmploye(Employe c, Long codeSup) {
        if(codeSup != null)
        	{
        	Employe empsup=em.find(Employe.class,codeSup);
        	c.setEmployeSup(empsup);
        	}	
		em.persist(c);
		return c;
	}

	@Override
	public Groupe addGroupe(Groupe c) {
		em.persist(c);
		return c;
	}

	@Override
	public void addEmployeToGroupe(Long codeemp, Long codeGr) {
		 if(codeemp != null && codeGr != null)
     	{
     	Employe emp=em.find(Employe.class,codeemp);
     	Groupe gr=em.find(Groupe.class,codeemp);
     	emp.getGroupes().add(gr);
     	gr.getEmployes().add(emp);
     
     	}	
		
	}

	@Override
	public Compte addCompte(Compte c, Long codeCli, Long codeemp) {
		
		if(codeemp != null && codeCli != null)
     	{
     	Employe employe=em.find(Employe.class,codeemp);
     	Client client=em.find(Client.class,codeCli);
     	c.setClient(client);
     	c.setEmploye(employe);
     	em.persist(c);
     	}	
		return c;
	}

	@Override
	public Operation addOperation(Operation o, String codeCompte, Long codeEmp) {
		Compte cp=consulterCompte(codeCompte);
		Employe emp=em.find(Employe.class, codeEmp);
		o.setCompte(cp);
     	o.setEmploye(emp);
     	em.persist(o);
		return o;
		
	}

	@Override
	public Compte consulterCompte(String code) {
		Compte c=em.find(Compte.class, code);
		if(c==null)throw new RuntimeException("compte introuvable");
		
		return c;
	}

	@Override
	public List<Operation> consulterOperationCompte(String codeCompte) {
		Query req=em.createQuery("select o from Operation o Where o.compte.codeCompte=:x");
		req.setParameter("x", codeCompte);
		return req.getResultList();
	}

	@Override
	public Client consulterClient(Long code) {
		Client c =em.find(Client.class,code);
		if(c==null)throw new RuntimeException("client introuvable");
		return null;
	}

	@Override
	public List<Client> consulterClient(String motcle) {
		Query req=em.createQuery("select o from Client o Where o.nomClient like : x");
		req.setParameter("x","%"+motcle+"%");
		return req.getResultList();
		
	}

	@Override
	public List<Compte> getCompteParClient(Long codecli) {
		Query req=em.createQuery("select o from Compte o Where o.client.codeClient=: x");
		req.setParameter("x",codecli);
		return req.getResultList();
		
	}

	@Override
	public List<Compte> getCompteParEmploye(Long codeemp) {
		Query req=em.createQuery("select o from Compte o Where o.employe.codeEmploye=: x");
		req.setParameter("x",codeemp);
		return req.getResultList();
		
	}

	@Override
	public List<Compte> listEployes() {
		Query req=em.createQuery("select o from Compte o");
		return req.getResultList();
	}

	@Override
	public List<Groupe> listGroupe() {
		Query req=em.createQuery("select o from Groupe o");
		return req.getResultList();
	}

	@Override
	public List<Employe> getEmployeByGroupe(Long codegr) {
		Query req=em.createQuery("select o from Employe o Where o.groupes.codeGroupe=: x");
		req.setParameter("x",codegr);
		return req.getResultList();
	}

}
