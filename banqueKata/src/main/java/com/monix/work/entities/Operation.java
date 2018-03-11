package com.monix.work.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
	@Type(name="V",value=Versement.class),
	@Type(name="R",value=Retrait.class)
})

@XmlSeeAlso({Retrait.class,Versement.class})
public class Operation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numeroOperation;
	private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name="code_compte")
    private Compte compte;
    
    @JsonIgnore
    @XmlTransient
    public Compte getCompte() {
		return compte;
	}

    @JsonSetter
	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	@ManyToOne
    @JoinColumn(name="code_employe")
    private Employe employe;
    
    
	public Operation() {
		super();
	}


	public Operation( Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}


	public Long getNumeroOperation() {
		return numeroOperation;
	}


	public void setNumeroOperation(Long numeroOperation) {
		this.numeroOperation = numeroOperation;
	}


	public Date getDateOperation() {
		return dateOperation;
	}


	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}

	 @JsonIgnore
	 @XmlTransient
	public Employe getEmploye() {
		return employe;
	}

	 @JsonSetter
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}


	

	


	
}
