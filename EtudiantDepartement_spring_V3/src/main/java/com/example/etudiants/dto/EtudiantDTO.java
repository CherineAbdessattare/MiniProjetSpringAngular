package com.example.etudiants.dto;

import java.util.Date;

import com.example.etudiants.entities.Departement;

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
	//private String nomDepart;
	

}
