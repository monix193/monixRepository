package com.monix.work.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.monix.work.entities.Groupe;
import com.monix.work.metier.GroupeMetier;


@RestController
public class GroupeRestController {

	@Autowired
	 private GroupeMetier groupeMetier;

		
		@RequestMapping(value="/groupes",method=RequestMethod.POST)
		
		public Groupe saveGroupe(@RequestBody Groupe c) {
			return groupeMetier.saveGroupe(c);
		}

		@RequestMapping(value="/groupes",method=RequestMethod.GET)
		public List<Groupe> listCompte() {
			return groupeMetier.listGroupe();
		}
}
