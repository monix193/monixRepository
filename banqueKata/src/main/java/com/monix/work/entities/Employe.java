package com.monix.work.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employe implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	
@Id
 private String codeEmploye;

 private String  nomEmploye;
 @ManyToOne
 @JoinColumn(name="codeEmpSup")
 private Employe employeSup;
 
 @ManyToMany
 @JoinTable(name="employegroupe")
 private  Collection<Groupe> groupes;
 
public Employe( String nomEmploye) {
	super();
	
	this.nomEmploye = nomEmploye;
	
}
public Employe( String nomEmploye,Employe employeSup) {
	super();
	
	this.nomEmploye = nomEmploye;
	this.employeSup = employeSup;
	
}

public Employe() {
	super();
}
public String getCodeEmploye() {
	return codeEmploye;
}
public void setCodeEmploye(String codeEmploye) {
	this.codeEmploye = codeEmploye;
}
public String getNomEmploye() {
	return nomEmploye;
}
public void setNomEmploye(String nomEmploye) {
	this.nomEmploye = nomEmploye;
}
@JsonIgnore
public Employe getEmployeSup() {
	return employeSup;
}
public void setEmployeSup(Employe employeSup) {
	this.employeSup = employeSup;
}
@JsonIgnore
public Collection<Groupe> getGroupes() {
	return groupes;
}
public void setGroupes(Collection<Groupe> groupes) {
	this.groupes = groupes;
}
 
}
