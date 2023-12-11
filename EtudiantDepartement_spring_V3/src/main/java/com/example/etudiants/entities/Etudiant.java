package com.example.etudiants.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Etudiant {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtudiant;
	private String nom;
	private String prenom;
	private String Email;
	private Date dateInscription;
	private String parcours;
	
	
	
	@ManyToOne
	private Departement departement;

	
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public Etudiant() {
		super();
		
	}
	
	
	
	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nom=" + nom + ", prenom=" + prenom + ", dateInscription="
				+ dateInscription + ", parcours=" + parcours + ", departement=" + departement + ", Email=" + Email
				+ "]";
	}
	public Etudiant(String nom, String prenom, Date dateInscription, String parcours, Departement departement,
			String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateInscription = dateInscription;
		this.parcours = parcours;
		this.departement = departement;
		this.Email = email;
	}
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public String getParcours() {
		return parcours;
	}
	public void setParcours(String parcours) {
		this.parcours = parcours;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	
}
