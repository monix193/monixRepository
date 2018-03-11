package com.monix.work.metier;

import java.util.List;

import com.monix.work.entities.Compte;

public interface CompteMetier {

	public Compte saveCompte(Compte c);
	public Compte getCompte(String s);
	public List <Compte> listCompte();

}
