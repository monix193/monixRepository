package com.monix.work.metier;

import java.util.List;

import com.monix.work.entities.Employe;

public interface EmployeMetier {

	Employe saveEmploye(Employe c);
	List <Employe> listEmploye();
}
