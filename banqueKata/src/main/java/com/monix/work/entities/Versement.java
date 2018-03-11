package com.monix.work.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;
@Entity
@DiscriminatorValue(value="V")
@XmlType(name="V")
public class Versement extends Operation {

	public Versement(){
		super();
	}
	
	public Versement(Date dateOperation,double montant){
		super( dateOperation, montant);
	}
	
}
