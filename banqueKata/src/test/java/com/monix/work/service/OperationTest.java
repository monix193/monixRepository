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

import com.monix.work.dao.OperationRepository;
import com.monix.work.entities.Client;
import com.monix.work.entities.Compte;
import com.monix.work.entities.CompteCourant;
import com.monix.work.entities.Employe;
import com.monix.work.entities.Groupe;
import com.monix.work.entities.Operation;
import com.monix.work.entities.Retrait;
import com.monix.work.entities.Versement;
import com.monix.work.metier.OperationMetier;
import com.monix.work.restController.ExceptionHandler.OperationServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationTest {

	
	@Autowired
	OperationMetier operationMetier;
	
	@MockBean
	private OperationRepository operationRepository;
	
	Compte  compte= new CompteCourant();
	Client  client= new Client();
	Employe employe=new Employe();
	Groupe  groupe =new Groupe();
	Operation versement=new  Versement();
	Operation versement1=new  Versement();
	Operation retrait=new  Retrait();
	Operation retrait1=new  Retrait();
	List <Operation>  listOperations=new ArrayList<Operation>();
	
	@Before
	public void setUp() throws Exception
	{ 
		groupe.setCodeGroupe(100L);
		groupe.setNomGroupe("GRP 1");
		
		employe.setCodeEmploye("E1");
		employe.setNomEmploye("Mansour");
		
		compte.setClient(client);
		compte.setCodeCompte("C1111");
		compte.setDaCreation(new Date());
		compte.setEmploye(employe);
		compte.setSolde(0);
		
		versement.setCompte(compte);
		versement.setEmploye(employe);
		versement.setDateOperation(new Date());
		versement.setNumeroOperation(100L);
		versement.setMontant(0);
		
		retrait.setCompte(compte);
		retrait.setEmploye(employe);
		retrait.setDateOperation(new Date());
		retrait.setNumeroOperation(100L);
		retrait.setMontant(0);
		
		
		versement1.setCompte(compte);
		versement1.setEmploye(employe);
		versement1.setDateOperation(new Date());
		versement1.setNumeroOperation(100L);
		versement1.setMontant(0);
		
		retrait1.setCompte(compte);
		retrait1.setEmploye(employe);
		retrait1.setDateOperation(new Date());
		retrait1.setNumeroOperation(100L);
		retrait1.setMontant(10000);
		
		
		
	}
	
	@Test
	public void testSaveOperation(){

	    Mockito.when(operationMetier.saveOperation(versement)).thenReturn(versement);
	    assertThat(operationRepository.save(versement)).isEqualTo(versement);
	
	}
	@Test
	public  void TestVersement ()
	{
		versement.setMontant(20000D);
	    compte.setSolde(compte.getSolde()+versement.getMontant());
		    Mockito.when(operationRepository.save(versement)).thenReturn(versement);
		    assertThat(operationMetier.saveOperation(versement)).isEqualTo(versement);
		    assertThat(versement.getMontant()).isEqualTo(20000D);
		    assertThat(compte.getSolde()).isEqualTo(20000D);
	}
	
	@Test
	public  void TestRetrait()
	{
		compte.setSolde(20000D);
		retrait.setMontant(5000D);
		 compte.setSolde(compte.getSolde()-retrait.getMontant());
	    Mockito.when(operationRepository.save(retrait)).thenReturn(retrait);
	    assertThat(operationMetier.saveOperation(retrait)).isEqualTo(retrait);
	    assertThat(retrait.getMontant()).isEqualTo(5000D);
	    assertThat(compte.getSolde()).isEqualTo(15000D);
       
	}
	@Test(expected=OperationServiceException.class)
	public  void TestRetraitWithMontantSuperieurSoldeException()
	{
		try
		{
			compte.setSolde(20000D);
			retrait.setMontant(21000D);
			 
			 operationMetier.retirer(compte, retrait.getMontant(), employe.getCodeEmploye());
		    Mockito.when(operationRepository.save(retrait)).thenReturn(retrait);
		  
		  
		}
		catch (OperationServiceException e) {
			
			throw new OperationServiceException("solde Insuffisant");
		}
		
       
	}
	
	@Test(expected=OperationServiceException.class)
	public  void TestOperationtWithMontantNegatifException ()
	{
		try
		{
		compte.setSolde(20000D);
		versement.setMontant(-50000D);
		
	    operationMetier.verser(compte, versement.getMontant(), employe.getCodeEmploye());
	    Mockito.when(operationRepository.save(versement)).thenReturn(versement);
	    
	}
	catch (OperationServiceException e) {
		
		throw new OperationServiceException("montant invalide");
	}
	}
	
	
	
}
