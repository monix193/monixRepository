package com.monix.work.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monix.work.entities.Compte;
import com.monix.work.entities.Operation;
import com.monix.work.entities.PageOperation;
import com.monix.work.metier.OperationMetier;

@RestController
public class OperationRestController {

	@Autowired
	private OperationMetier operationMetier;

	
	@RequestMapping(value="/operations",method=RequestMethod.POST)
	public Operation saveOperation(@RequestBody Operation c) {
		return operationMetier.saveOperation(c);
	}
    
	 
	
	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public PageOperation getOperation(@RequestParam String codeCompte, @RequestParam int page,@RequestParam int size) {
		return operationMetier.getOperation(codeCompte,page,size);
	}
	
	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public Compte verser(@RequestParam String code, 
		               	@RequestParam Double montant, 
		               	@RequestParam String codeEmp) {
		return operationMetier.verser(code, montant, codeEmp);
	}

	@RequestMapping(value="/retrait",method=RequestMethod.PUT)
	public Compte retirer(@RequestParam String code, 
		               	@RequestParam Double montant, 
		               	@RequestParam String codeEmp){
		return operationMetier.retirer(code, montant, codeEmp);
	}

	@RequestMapping(value="/virement",method=RequestMethod.PUT)
	public Compte virement(@RequestParam String code1,@RequestParam String code2,@RequestParam Double montant, @RequestParam String codeEmp) {
		return operationMetier.virement(code1, code2, montant, codeEmp);
	}

		
		
}
