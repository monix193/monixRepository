package com.monix.work.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monix.work.dao.ClientRepository;
import com.monix.work.dao.EmployeRepository;
import com.monix.work.entities.Employe;
import com.monix.work.metier.EmployeMetier;

@Service
public class EmployeMetierImpl implements EmployeMetier {

	@Autowired
	 private EmployeRepository employeRepository;

	@Override
	public Employe saveEmploye(Employe c) {
		// TODO Auto-generated method stub
		return employeRepository.save(c);
	}

	@Override
	public List<Employe> listEmploye() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

}
