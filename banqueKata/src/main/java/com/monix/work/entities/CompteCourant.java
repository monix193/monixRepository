package com.monix.work.entities;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;
@Entity
@DiscriminatorValue(value="CC")
@XmlType(name="CC")
public class CompteCourant extends Compte {
		
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private double decouvert;

public double getDecouvert() {
	return decouvert;
}

public void setDecouvert(double decouvert) {
	this.decouvert = decouvert;
}

public CompteCourant(Date daCreation, double solde, double decouvert) {
	super(daCreation, solde);
	this.decouvert = decouvert;
}

public CompteCourant() {
	super();
}

}
