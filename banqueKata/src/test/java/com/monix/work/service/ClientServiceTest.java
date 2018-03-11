package com.monix.work.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.monix.work.dao.ClientRepository;
import com.monix.work.entities.Client;
import com.monix.work.entities.Compte;
import com.monix.work.entities.CompteCourant;
import com.monix.work.entities.Employe;
import com.monix.work.entities.Groupe;
import com.monix.work.metier.ClientMetier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {


	@Autowired
	ClientMetier clientMetier;

	@MockBean
	private ClientRepository clientRepository;

	Compte  compte= new CompteCourant();
	Client  client= new Client();
	Employe employe=new Employe();
	Groupe   groupe= new Groupe();
	
	@Before
	public void setUp() throws Exception
	{ 
		groupe.setCodeGroupe(100L);
		groupe.setNomGroupe("GRP 1");
		
		employe.setCodeEmploye("E1");
		employe.setNomEmploye("Mansour");
		
		compte.setClient(client);
		compte.setCodeCompte("C1234");
		compte.setDaCreation(new Date());
		compte.setEmploye(employe);
		compte.setSolde(0);
		
		client.setCodeClient("C1111");	
		client.setNomClient("Mike");
		client.setAdresseClient("adresse1");
		
	}
	
	@Test
	public void saveClientTest() { 
       
	    Mockito.when(clientMetier.saveClient(client)).thenReturn(client);
	    assertThat(clientRepository.save(client)).isEqualTo(client);
	
	}
	
	@Test
	public void ListClientTest() {

		Client  client1= new Client();
		client1.setCodeClient("C1111");	
		client1.setNomClient("Mike");
		client1.setAdresseClient("adresse1");
		
		
		Client  client2= new Client();
		client2.setCodeClient("C1111");	
		client2.setNomClient("Mike");
		client2.setAdresseClient("adresse1");
		
		List<Client> clientList = new ArrayList<Client>();
		clientList.add(client1);
		clientList.add(client2);
		
		Mockito.when(clientRepository.findAll()).thenReturn(clientList);
		
		assertThat(clientMetier.listClient()).isEqualTo(clientList);
	

	}


}
