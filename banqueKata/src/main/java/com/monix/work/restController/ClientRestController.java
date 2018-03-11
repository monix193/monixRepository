package com.monix.work.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.monix.work.entities.Client;
import com.monix.work.metier.ClientMetier;

@RestController
public class ClientRestController {
	
	@Autowired
 private ClientMetier clientMetier;

	
	@RequestMapping(value="/clients",method=RequestMethod.POST)
	
	public Client saveClient(@RequestBody Client c) {
		return clientMetier.saveClient(c);
	}

	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public List<Client> listClient() {
		return clientMetier.listClient();
	}
	
	
	
}
