package com.monix.work.metier;

import java.util.List;

import com.monix.work.entities.Client;

public interface ClientMetier {
	public Client saveClient(Client c);
	public List <Client> listClient();
}
