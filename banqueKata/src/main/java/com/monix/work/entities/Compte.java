package com.monix.work.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte",discriminatorType=DiscriminatorType.STRING,length=4)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
	@Type(name="CC",value=CompteCourant.class),
	@Type(name="CE",value=CompteEpargne.class)
 })

@XmlSeeAlso({CompteCourant.class,CompteEpargne.class})

@JsonDeserialize(as = CompteEpargne.class)
public abstract class Compte implements Serializable{
	
	@Id
	private String codeCompte;
	private Date daCreation;
	private double solde;
	
	@ManyToOne
	@JoinColumn(name="code_client")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="code_employe")
	private Employe employe;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="compte")
	private Collection<Operation> operations;
	
	@Override
	public String toString() {
		return "Compte [codeCompte=" + codeCompte + ", Client=" + client + "]";
	}
	public Compte(Date daCreation, double solde) {
		super();
		this.daCreation = daCreation;
		this.solde = solde;
	}
	public Compte() {
		super();
	}
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDaCreation() {
		return daCreation;
	}
	public void setDaCreation(Date date) {
		this.daCreation = date;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Operation> getOperations() {
		return operations;
	}
	 
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
}
