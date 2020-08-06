package com.monix.work.metier;

import java.util.List;

import com.monix.work.entities.Compte;

public interface CompteMetier {

	Compte saveCompte(Compte c);
	Compte getCompte(String s);
	List <Compte> listCompte();

}
