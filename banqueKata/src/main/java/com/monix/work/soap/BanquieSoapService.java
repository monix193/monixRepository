package com.monix.work.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.monix.work.entities.Compte;
import com.monix.work.entities.Operation;
import com.monix.work.entities.PageOperation;
import com.monix.work.metier.CompteMetier;
import com.monix.work.metier.OperationMetier;
import com.monix.work.restController.ExceptionHandler.OperationServiceException;

@WebService
@Component
public class BanquieSoapService {
 
	private CompteMetier compteCompteMetier;
	private OperationMetier operationMetier;
	
	/*
	 * 
	 * @WebMethod public Compte verser(@WebParam(name="code")String
	 * code,@WebParam(name="montant") Double montant,
	 * 
	 * @WebParam(name="codeEmp")String codeEmp) throws OperationServiceException {
	 * return operationMetier.verser(code, montant, codeEmp); }
	 * 
	 * @WebMethod public Compte retirer(@WebParam(name="code") String code,
	 * 
	 * @WebParam(name="montant") Double montant, @WebParam(name="codeEmp")String
	 * codeEmp) throws OperationServiceException { return
	 * operationMetier.retirer(code, montant, codeEmp); }
	 * 
	 * @WebMethod public Compte virement(@WebParam(name="code1")String
	 * code1,@WebParam(name="code2") String code2,
	 * 
	 * @WebParam(name="montant") Double montant, @WebParam(name="codeEmp")String
	 * codeEmp) throws OperationServiceException{ return
	 * operationMetier.virement(code1, code2, montant, codeEmp); }
	 * 
	 * @WebMethod public PageOperation
	 * getOperation(@WebParam(name="codeCompte")String
	 * codeCompte,@WebParam(name="page") int page,@WebParam(name="size") int
	 * size)throws OperationServiceException { return
	 * operationMetier.getOperation(codeCompte, page, size); }
	 * 
	 * @WebMethod public Compte getCompte(@WebParam(name="codeCompte")String s) {
	 * return compteCompteMetier.getCompte(s); }
	 */
	
	}
