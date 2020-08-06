package com.monix.work.metier;

import java.util.List;

import com.monix.work.entities.Compte;
import com.monix.work.entities.Operation;
import com.monix.work.entities.PageOperation;
import com.monix.work.entities.Retrait;
import com.monix.work.entities.Versement;

public interface OperationMetier {

	Operation saveOperation(Operation c);
	List <Operation> listOperation();
	Compte verser(Compte c, Double montant, String codeEmp) ;
	Compte retirer(Compte c, Double montant, String codeEmp) ;
	Compte virement(Compte c1, Compte c2, Double solde, String codeEmp) ;
	PageOperation getOperation(String codeCompte, int page, int size);
	

}
