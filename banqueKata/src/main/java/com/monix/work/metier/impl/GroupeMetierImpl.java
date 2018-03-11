package com.monix.work.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monix.work.dao.GroupeRepository;
import com.monix.work.entities.Groupe;
import com.monix.work.metier.GroupeMetier;

@Service
public class GroupeMetierImpl implements GroupeMetier{

	@Autowired
	GroupeRepository groupeRepository;
	@Override
	public Groupe saveGroupe(Groupe c) {
		// TODO Auto-generated method stub
		return groupeRepository.save(c);
	}

	@Override
	public List<Groupe> listGroupe() {
		// TODO Auto-generated method stub
		return groupeRepository.findAll();
	}

}
