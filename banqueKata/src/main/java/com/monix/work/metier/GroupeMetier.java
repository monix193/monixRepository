package com.monix.work.metier;

import java.util.List;

import com.monix.work.entities.Groupe;

public interface GroupeMetier {

	Groupe saveGroupe(Groupe c);
	List <Groupe> listGroupe();
}
