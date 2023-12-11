package com.example.etudiants.entities;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
public class Departement {
	
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDepart;
	private String nomDepart;
	private String DescriptionDepart;
	
	@JsonIgnore
	@OneToMany(mappedBy = "departement")
	private List<Etudiant> etudiants;


}
