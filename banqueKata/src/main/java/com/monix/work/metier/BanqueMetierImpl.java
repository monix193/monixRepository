package com.monix.work.metier;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.monix.work.dao.IBanqueDao;
import com.monix.work.entities.Client;
import com.monix.work.entities.Compte;
import com.monix.work.entities.Employe;
import com.monix.work.entities.Groupe;
import com.monix.work.entities.Operation;
import com.monix.work.entities.Versement;

@Transactional
public class BanqueMetierImpl implements IBanqueMetier {

	private IBanqueDao  dao;
	
	public IBanqueDao getDao() {
		return dao;
	}

	public void setDao(IBanqueDao dao) {
		this.dao = dao;
	}
 
	@Override
	public Client addClient(Client c) {
		
		return dao.addClient(c);
	}

	
	@Override
	public Employe addEmploye(Employe c, Long codeSup) {
		// TODO Auto-generated method stub
		return dao.addEmploye(c,codeSup);
	}

	@Override
	public Groupe addGroupe(Groupe c) {
		// TODO Auto-generated method stub
		return dao.addGroupe(c);
	}

	@Override
	public void addEmployeToGroupe(Long codeemp, Long codeGr) {
		 dao.addEmployeToGroupe(codeemp,codeGr);
       return;
	}

	@Override
	public Compte addCompte(Compte c, Long codeCli, Long codeemp) {
		return dao.addCompte(c, codeCli, codeemp);
	}

	@Override
	public void verser(double mt, String codeCompte, Long codeEmp) {
		dao.addOperation(new Versement(new Date(),mt), codeCompte, codeEmp);
		Compte cp=dao.consulterCompte(codeCompte);
		cp.setSolde(cp.getSolde()+mt);

	}

	@Override
	public void retirer(double mt, String codeCompte, Long codeEmp) {
		dao.addOperation(new Versement(new Date(),mt), codeCompte, codeEmp);
		Compte cp=dao.consulterCompte(codeCompte);
		cp.setSolde(cp.getSolde()-mt);

	}

	@Override
	public void virement(double mt, String codeCp1, String codeCp2, Long codeEmp) {
		retirer( mt,  codeCp1,  codeEmp);
		retirer( mt,  codeCp2,  codeEmp);

	}

	@Override
	public Compte consulterCompte(String code) {
		
		return dao.consulterCompte(code);
	}

	@Override
	public List<Operation> consulterOperationCompte(String codeCompte) {
		// TODO Auto-generated method stub
		return dao.consulterOperationCompte(codeCompte);
	}

	@Override
	public Client consulterClient(Long code) {	
		return dao.consulterClient(code);
	}

	@Override
	public List<Client> consulterClient(String motcle) {
		// TODO Auto-generated method stub
		return dao.consulterClient(motcle);
	}

	@Override
	public List<Compte> getCompteParClient(Long codecli) {
		// TODO Auto-generated method stub
		return dao.getCompteParClient(codecli);
	}

	@Override
	public List<Compte> getCompteParEmploye(Long codeemp) {
		// TODO Auto-generated method stub
		return dao.getCompteParEmploye(codeemp);
	}

	@Override
	public List<Compte> listEployes() {
		// TODO Auto-generated method stub
		return dao.listEployes();
	}

	@Override
	public List<Groupe> listGroupe() {
		// TODO Auto-generated method stub
		return dao.listGroupe();
	}

	@Override
	public List<Employe> getEmployeByGroupe(Long gr) {
		// TODO Auto-generated method stub
		return dao.getEmployeByGroupe(gr);
	}

}
