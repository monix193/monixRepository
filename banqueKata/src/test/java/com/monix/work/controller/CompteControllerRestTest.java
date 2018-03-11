package com.monix.work.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
import com.monix.work.metier.CompteMetier;
import com.monix.work.restController.CompteRestController;

@RunWith(SpringRunner.class)
@WebMvcTest(value=CompteRestController.class,secure = false)
public class CompteControllerRestTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CompteMetier compteMetier;
	
	@Test
	public void testGetCompteTest() throws Exception {
		
			
		Compte  compte= new CompteCourant();
		Client  client= new Client();
		Employe employe=new Employe();
		Groupe  groupe =new Groupe();
		
		groupe.setCodeGroupe(100L);
		groupe.setNomGroupe("GRP1");
		employe.setCodeEmploye("E1");
		employe.setNomEmploye("Mansour");
		
		compte.setClient(client);
		compte.setCodeCompte("C1111");
		compte.setDaCreation(new Date());
		compte.setEmploye(employe);
		compte.setSolde(0);
		
		
Mockito.when(compteMetier.getCompte("C1111")).thenReturn(compte);
		
		String URI = "/comptes/C1111";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(compte);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).contains("C1111");
	}
	
	@Test
	public void testGetAllBookedTickets() throws Exception {

		Compte  compte= new CompteCourant();
		Client  client= new Client();
		Employe employe=new Employe();
		Groupe  groupe =new Groupe();
		
		groupe.setCodeGroupe(100L);
		groupe.setNomGroupe("GRP1");
		employe.setCodeEmploye("E1");
		employe.setNomEmploye("Mansour");
		
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
		
		Mockito.when(compteMetier.listCompte()).thenReturn(compteList);
		
		String URI = "/comptes";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(compteList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}


/**
 * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
 */
private String mapToJson(Object object) throws JsonProcessingException {
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.writeValueAsString(object);
}


}
