package com.monix.work.metier.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monix.work.dao.CompteRepository;
import com.monix.work.dao.EmployeRepository;
import com.monix.work.dao.OperationRepository;
import com.monix.work.entities.Compte;
import com.monix.work.entities.Employe;
import com.monix.work.entities.Operation;
import com.monix.work.entities.PageOperation;
import com.monix.work.entities.Retrait;
import com.monix.work.entities.Versement;
import com.monix.work.metier.OperationMetier;
import com.monix.work.restController.ExceptionHandler.OperationServiceException;

@Service
@Transactional
public class OperationMetierImpl implements OperationMetier{

	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	EmployeRepository employeRepository;
	
	
	@Override
	public Operation saveOperation(Operation c) {
		// TODO Auto-generated method stub
		return operationRepository.save(c);
	}

	@Override
	public List<Operation> listOperation() {
		// TODO Auto-generated method stub
		return operationRepository.findAll();
	}

	@Override
	public Compte verser(Compte c, Double montant, String codeEmp) {
		// TODO Auto-generated method stub
		if (montant==null || montant<= 0) throw new OperationServiceException("le montant saisi est invalide ");
		if (c==null) throw new OperationServiceException("Ce compte n'existe pas : veuillez recommencer");
		Employe e =employeRepository.getOne(codeEmp);
		Operation o= new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(c);
		o.setEmploye(e);
		operationRepository.save(o);
		c.setSolde(c.getSolde()+montant);
		return c;
	}

	@Override
	public Compte retirer(Compte c,Double montant , String codeEmp) {
		// TODO Auto-generated method stub
		if ( montant == null || montant<= 0) throw new OperationServiceException("le montant saisi est invalide ");
		if (c==null) throw new OperationServiceException("Ce compte n'existe pas : veuillez recommencer");
		
		if(c.getSolde()< montant) throw new OperationServiceException("solde Insuffisant");
		
		Employe e =employeRepository.getOne(codeEmp);
		Operation o= new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(c);
		o.setEmploye(e);
		operationRepository.save(o);
		c.setSolde(c.getSolde()-montant);
		
		return c;
	}

	@Override
	public Compte virement(Compte c1, Compte c2, Double montant, String codeEmp) {

		Compte c =retirer(c1, montant, codeEmp);
		verser(c2, montant, codeEmp);
		return c;
	
			}

	@Override
	public PageOperation getOperation(String codeCompte, int page, int size) {
		// TODO Auto-generated method stub
		Page<Operation> ops=operationRepository.getOperations(codeCompte, new PageRequest(page, size));
		if (ops==null) throw new OperationServiceException("aucune opration pour ce compte");
		PageOperation pOp= new PageOperation();
		pOp.setOperation(ops.getContent());
		pOp.setNombreOperation(ops.getNumberOfElements());
		pOp.setPage(ops.getNumber());
		pOp.setTotalPages(ops.getTotalPages());
		pOp.setTotalOperation((int)ops.getTotalElements());
		return pOp;
	}

}
