package com.monix.work.metier;

import java.util.List;

import com.monix.work.entities.Client;

public interface ClientMetier {
	Client saveClient(Client c);
	List <Client> listClient();
}
