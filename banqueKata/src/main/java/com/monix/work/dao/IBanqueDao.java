package com.monix.work.dao;

import java.util.List;

import com.monix.work.entities.Client;
import com.monix.work.entities.Compte;
import com.monix.work.entities.Employe;
import com.monix.work.entities.Groupe;
import com.monix.work.entities.Operation;

public interface IBanqueDao {

	Client addClient(Client c);
	Employe addEmploye(Employe c, Long codeSup);
	Groupe addGroupe(Groupe c);
	void addEmployeToGroupe(Long codeemp, Long codeGr);
	Compte addCompte(Compte c, Long codeCli, Long codeemp);
	//public Compte addEmploye(Compte c,Long codeCli,Long codeemp);	
    Operation addOperation(Operation c, String codeCompte, Long codeEmp);
	Compte consulterCompte(String code);
	List<Operation> consulterOperationCompte(String codeCompte);
	Client consulterClient(Long code);
	List<Client> consulterClient(String motcle);
	List<Compte> getCompteParClient(Long codecli);
	List<Compte> getCompteParEmploye(Long codeemp);
	List<Compte> listEployes();
	List<Groupe> listGroupe();
	List<Employe> getEmployeByGroupe(Long gr);
	


}
