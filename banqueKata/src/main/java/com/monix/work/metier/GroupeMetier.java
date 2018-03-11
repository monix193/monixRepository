package com.monix.work.metier;

import java.util.List;

import com.monix.work.entities.Groupe;

public interface GroupeMetier {

	public Groupe saveGroupe(Groupe c);
	public List <Groupe> listGroupe();
}
