package com.example.etudiants.dto;

import java.util.Date;

import com.example.etudiants.entities.Departement;
import com.example.etudiants.entities.Image;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class EtudiantDTO {
	
	private Long idEtudiant;
	private String nom;
	private String prenom;
	private Date dateInscription;
	private String Email;
	private String parcours;
	private Departement departement;
	@OneToOne
	private Image image;
	
	//private String nomDepart;
	

}
