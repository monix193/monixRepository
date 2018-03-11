package com.monix.work.metier;

import java.util.List;

import com.monix.work.entities.Employe;

public interface EmployeMetier {

	public Employe saveEmploye(Employe c);
	public List <Employe> listEmploye();
}
