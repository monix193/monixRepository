package com.monix.work.metier.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monix.work.dao.CompteRepository;
import com.monix.work.entities.Compte;
import com.monix.work.metier.CompteMetier;
import com.monix.work.restController.ExceptionHandler.CompteServiceException;

@Service
public class CompteMetierImpl implements CompteMetier{
@Autowired
CompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte c) {
		// TODO Auto-generated method stub
		c.setDaCreation(new Date());
		return compteRepository.save(c);
	}
    
	@Override
	public List<Compte> listCompte() {
		// TODO Auto-generated method stub
		return compteRepository.findAll();
	}

	@Override
	public Compte getCompte(String s) {
		// TODO Auto-generated method stub
		 Compte c=null;
		 try {
		 Optional<Compte> compte= compteRepository.findById(s);
		   c=compte.get();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new CompteServiceException("Compte non trouvé");
		}
		 return c;
	}

}
