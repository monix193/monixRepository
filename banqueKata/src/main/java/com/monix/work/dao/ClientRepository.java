package com.monix.work.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monix.work.entities.Client;

public interface ClientRepository extends JpaRepository <Client, String>{

}
