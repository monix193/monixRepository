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

import com.monix.work.dao.CompteRepository;
import com.monix.work.entities.Client;
import com.monix.work.entities.Compte;
import com.monix.work.entities.CompteCourant;
import com.monix.work.entities.Employe;
import com.monix.work.entities.Groupe;
import com.monix.work.metier.CompteMetier;
import com.monix.work.restController.ExceptionHandler.CompteServiceException;
import com.monix.work.restController.ExceptionHandler.OperationServiceException;



	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class CompteServiceTest {

		@Autowired
		CompteMetier compteMetier;

		@MockBean
		private CompteRepository compteRepository;

		Compte  compte= new CompteCourant();
		Client  client= new Client();
		Employe employe=new Employe();
		Groupe  groupe =new Groupe();
			
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
			
			
		}
		
		@Test
		public void saveCompteTest() {
			 Compte compte= new CompteCourant();
				compte.setClient(client);
				compte.setCodeCompte("C1234");
				compte.setDaCreation(new Date());
				compte.setEmploye(employe);
				compte.setSolde(0);
				 Mockito.when(compteRepository.save(compte)).thenReturn(compte);
				  assertThat(compteMetier.saveCompte(compte)).isEqualTo(compte);
					
		}
		
		@Test
		public void getCompteTest() {
			 Compte compte= new CompteCourant();
				compte.setClient(client);
				compte.setCodeCompte("C1111");
				compte.setDaCreation(new Date());
				compte.setEmploye(employe);
				compte.setSolde(0);
				 	
		}
		
		@Test(expected=CompteServiceException.class)
		public  void TestCompteNullException()
		{
			try
			{
				Compte compte= new CompteCourant();
				compte.setClient(client);
				compte.setCodeCompte("C1111");
				compte.setDaCreation(new Date());
				compte.setEmploye(employe);
				compte.setSolde(0);
				
				Mockito.when(compteRepository.getOne("C1111")).thenReturn(compte);
			    assertThat(compteMetier.getCompte("C1112")).isEqualTo(compte);
				  
			  
			}
			catch (CompteServiceException e) {
				
				throw new CompteServiceException("Compte non trouve");
			}
			
	       
		}
		@Test
		public void ListCompteTest() {
			Compte  compte1= new CompteCourant();
			compte1.setClient(client);
			compte1.setCodeCompte("C1234");
			compte1.setDaCreation(new Date());
			compte1.setEmploye(employe);
			compte1.setSolde(0);
			
			Compte  compte2= new CompteCourant();
			compte2.setClient(client);
			compte2.setCodeCompte("C1234");
			compte2.setDaCreation(new Date());
			compte2.setEmploye(employe);
			compte2.setSolde(0);
			
			List<Compte> compteList = new ArrayList<Compte>();
			compteList.add(compte1);
			compteList.add(compte2);
			
			Mockito.when(compteRepository.findAll()).thenReturn(compteList);
			
			assertThat(compteMetier.listCompte()).isEqualTo(compteList);
		}

		
}
