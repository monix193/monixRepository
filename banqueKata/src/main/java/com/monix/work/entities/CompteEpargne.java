package com.monix.work.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue(value="CE")
@XmlType(name="CE")
public class CompteEpargne  extends Compte{
private double taux;

public CompteEpargne(Date daCreation, double solde, double taux) {
	super(daCreation, solde);
	this.taux = taux;
}

public CompteEpargne() {
	super();
}

public double getTaux() {
	return taux;
}

public void setTaux(double taux) {
	this.taux = taux;
}


}
