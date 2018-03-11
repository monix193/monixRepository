package com.monix.work.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;
@Entity
@DiscriminatorValue(value="R")
@XmlType(name="R")
public class Retrait extends Operation {


	public Retrait(){
		super();
	}
	
	public Retrait(Date dateOperation,double montant){
		super( dateOperation, montant);
	}
}
