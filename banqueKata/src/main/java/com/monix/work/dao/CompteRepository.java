package com.monix.work.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monix.work.entities.Compte;

public interface CompteRepository extends JpaRepository <Compte, String>{

}
