package com.monix.work.metier;

import java.util.List;

import com.monix.work.entities.Compte;
import com.monix.work.entities.Operation;
import com.monix.work.entities.PageOperation;
import com.monix.work.entities.Retrait;
import com.monix.work.entities.Versement;

public interface OperationMetier {

	public Operation saveOperation(Operation c);
	public List <Operation> listOperation();
	public Compte verser(Compte c,Double montant , String codeEmp) ;
	public Compte retirer(Compte c,Double montant,String codeEmp) ;
	public Compte virement(Compte c1,Compte c2, Double solde,String codeEmp) ;
	public  PageOperation getOperation(String codeCompte, int page, int size);
	

}
