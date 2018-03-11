package com.monix.work.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.monix.work.dao.GroupeRepository;
import com.monix.work.entities.Client;
import com.monix.work.entities.Compte;
import com.monix.work.entities.CompteCourant;
import com.monix.work.entities.Employe;
import com.monix.work.entities.Groupe;
import com.monix.work.metier.GroupeMetier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupeServiceTest {


	@Autowired
	GroupeMetier groupeMetier;

	@MockBean
	private GroupeRepository groupeRepository;

	Compte  compte= new CompteCourant();
	Client  client= new Client();
	Employe employe=new Employe();
	Groupe   groupe= new Groupe();
	List<Groupe> groupeList= new ArrayList<Groupe>();
	List<Employe> employeList= new ArrayList<Employe>();

	@Before
	public void setUp() throws Exception
	{ 
		groupe.setCodeGroupe(100L);
		groupe.setNomGroupe("GRP 1");
		
		employe.setCodeEmploye("E1");
		employe.setNomEmploye("Mansour");
		
		
			groupeList.add(groupe);
		
		
		employeList.add(employe);
		
		employe.setGroupes(groupeList);
		groupe.setEmployes(employeList);
		
		
		
		
		client.setCodeClient("C1111");	
		client.setNomClient("Mike");
		client.setAdresseClient("adresse1");
		
	}
	
	@Test
	public void saveClientTest() { 
       
	    Mockito.when(groupeRepository.save(groupe)).thenReturn(groupe);
	    assertThat(groupeMetier.saveGroupe(groupe)).isEqualTo(groupe);
	
	}
	
	@Test
	public void ListClientTest() {

		Groupe  groupe1= new Groupe();
		groupe.setCodeGroupe(200L);
		groupe.setNomGroupe("GRP3");
		
		Groupe  groupe2= new Groupe();
		groupe2.setCodeGroupe(300L);
		groupe2.setNomGroupe("GRP4");
		
		List<Groupe> groupeList = new ArrayList<Groupe>();
		groupeList.add(groupe1);
		groupeList.add(groupe2);
		
		Mockito.when(groupeRepository.findAll()).thenReturn(groupeList);
		
		assertThat(groupeMetier.listGroupe()).isEqualTo(groupeList);
	

	}




}
