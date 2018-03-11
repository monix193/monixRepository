package com.monix.work.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monix.work.entities.Employe;

public interface EmployeRepository  extends JpaRepository <Employe, String>{

}
