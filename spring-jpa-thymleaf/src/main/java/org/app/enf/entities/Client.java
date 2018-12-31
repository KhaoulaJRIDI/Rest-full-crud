package org.app.enf.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@NotEmpty
@Size(min=5,max=30)
private String nom;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date dateNaissance;
@NotEmpty
@Email
private String email;


public Client() {
	super();
	// TODO Auto-generated constructor stub
}


public Client(String nom, Date dateNaissance, String email) {
	super();
	this.nom = nom;
	this.dateNaissance = dateNaissance;
	this.email = email;
}






public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public Date getDateNaissance() {
	return dateNaissance;
}


public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}





}
