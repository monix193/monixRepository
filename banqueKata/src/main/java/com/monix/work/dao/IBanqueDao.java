package com.monix.work.dao;

import java.util.List;

import com.monix.work.entities.Client;
import com.monix.work.entities.Compte;
import com.monix.work.entities.Employe;
import com.monix.work.entities.Groupe;
import com.monix.work.entities.Operation;

public interface IBanqueDao {

	public Client addClient(Client c);
	public Employe addEmploye(Employe c,Long codeSup);
	public Groupe addGroupe(Groupe c);
	public void addEmployeToGroupe(Long codeemp,Long codeGr);
	public Compte addCompte(Compte c,Long codeCli,Long codeemp);
	//public Compte addEmploye(Compte c,Long codeCli,Long codeemp);	
	public Operation addOperation(Operation c,String codeCompte,Long codeEmp);
	public Compte consulterCompte(String code);
	public List<Operation> consulterOperationCompte(String codeCompte);
	public Client consulterClient(Long code);
	public List<Client> consulterClient(String motcle);
	public List<Compte> getCompteParClient(Long codecli);
	public List<Compte> getCompteParEmploye(Long codeemp);
	public List<Compte> listEployes();
	public List<Groupe> listGroupe();
	public List<Employe> getEmployeByGroupe(Long gr);
	


}
