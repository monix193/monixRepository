package com.monix.work.metier;

import java.util.List;

import com.monix.work.entities.Compte;
import com.monix.work.entities.Operation;
import com.monix.work.entities.PageOperation;

public interface OperationMetier {

	public Operation saveOperation(Operation c);
	public List <Operation> listOperation();
	public Compte verser(String code, Double montant, String codeEmp) ;
	public Compte retirer(String code, Double montant,String codeEmp) ;
	public Compte virement(String code1,String code2, Double solde,String codeEmp) ;
	public  PageOperation getOperation(String codeCompte, int page, int size);
	

}
