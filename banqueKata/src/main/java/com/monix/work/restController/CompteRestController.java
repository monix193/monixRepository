package com.monix.work.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.monix.work.entities.Compte;
import com.monix.work.metier.CompteMetier;

@RestController
public class CompteRestController {

	@Autowired
	 private CompteMetier compteMetier;

		
		@RequestMapping(value="/comptes",method=RequestMethod.POST)
		
		public Compte saveClient(@RequestBody Compte c) {
			return compteMetier.saveCompte(c);
		}

		@RequestMapping(value="/comptes",method=RequestMethod.GET)
		public List<Compte> listCompte() {
			return compteMetier.listCompte();
		}
		
		@RequestMapping(value="/comptes/{code}",method=RequestMethod.GET)
		public Compte getCompte(@PathVariable String code) {
			
			 return compteMetier.getCompte(code);
		}

}
