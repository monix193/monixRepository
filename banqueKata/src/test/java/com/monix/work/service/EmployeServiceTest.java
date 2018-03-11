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

import com.monix.work.dao.EmployeRepository;
import com.monix.work.entities.Client;
import com.monix.work.entities.Compte;
import com.monix.work.entities.CompteCourant;
import com.monix.work.entities.Employe;
import com.monix.work.entities.Groupe;
import com.monix.work.metier.EmployeMetier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceTest {


	@Autowired
	EmployeMetier employeMetier;

	@MockBean
	private EmployeRepository employeRepository;

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
       
	    Mockito.when(employeRepository.save(employe)).thenReturn(employe);
	    assertThat(employeMetier.saveEmploye(employe)).isEqualTo(employe);
	
	}
	
	@Test
	public void ListClientTest() {

		Employe  employe1= new Employe();
		employe1.setCodeEmploye("E1");
		employe1.setNomEmploye("Mansour");
		employe1.setGroupes(groupeList);
		
		
		Employe  employe2= new Employe();
		employe2.setCodeEmploye("E1");
		employe2.setNomEmploye("emilie");
		employe2.setGroupes(groupeList);
		
		
		List<Employe> employeList = new ArrayList<Employe>();
		employeList.add(employe1);
		employeList.add(employe2);
		
		Mockito.when(employeRepository.findAll()).thenReturn(employeList);
		
		assertThat(employeMetier.listEmploye()).isEqualTo(employeList);
	

	}


}
