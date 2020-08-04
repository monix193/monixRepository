package com.monix.work.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monix.work.entities.Client;
import com.monix.work.entities.Compte;
import com.monix.work.entities.CompteCourant;
import com.monix.work.entities.Employe;
import com.monix.work.entities.Groupe;
import com.monix.work.entities.Operation;
import com.monix.work.entities.Retrait;
import com.monix.work.entities.Versement;
import com.monix.work.metier.OperationMetier;
import com.monix.work.restController.OperationRestController;

@RunWith(SpringRunner.class)
@WebMvcTest(value=OperationRestController.class,secure = false)
public class OperationControllerTest {


	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OperationMetier operationMetier;
	
	@Test
	public void testVersement() throws Exception {
		
		Compte  compte= new CompteCourant();
		Client  client= new Client();
		Employe employe=new Employe();
		Groupe  groupe =new Groupe();
		Operation versement=new  Versement();
		
		groupe.setCodeGroupe(100L);
		groupe.setNomGroupe("GRP1");
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
		
		String inputInJson = this.mapToJson(compte);
		
		String URI = "/versement";
		
		Mockito.when(operationMetier.verser(compte, 20000D, "E1")).thenReturn(compte);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				
				.put(URI)
	            .param("code","C1111")
	            .param("montant","20000D")   
	            .param("codeEmp","E1")
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).contains("C1111");
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testRetrait() throws Exception{
		

		
		Compte  compte= new CompteCourant();
		Client  client= new Client();
		Employe employe=new Employe();
		Groupe  groupe =new Groupe();
		Operation retrait=new  Retrait();
		
		groupe.setCodeGroupe(100L);
		groupe.setNomGroupe("GRP1");
		employe.setCodeEmploye("E1");
		employe.setNomEmploye("Mansour");
		
		compte.setClient(client);
		compte.setCodeCompte("C1111");
		compte.setDaCreation(new Date());
		compte.setEmploye(employe);
		compte.setSolde(0);
		
		retrait.setCompte(compte);
		retrait.setEmploye(employe);
		retrait.setDateOperation(new Date());
		retrait.setNumeroOperation(100L);
		retrait.setMontant(0);
		
		String inputInJson = this.mapToJson(compte);
		
		String URI = "/retrait";
		
		Mockito.when(operationMetier.retirer(compte, 20000D, "E1")).thenReturn(compte);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				
				.put(URI)
	            .param("code","C1111")
	            .param("montant","20000D")   
	            .param("codeEmp","E1")
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
	     assertThat(outputInJson).contains("C1111");
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	
	}
	/**
	 * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
	 */
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	

}
