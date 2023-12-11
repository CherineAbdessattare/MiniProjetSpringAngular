package com.example.etudiants.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.etudiants.dto.EtudiantDTO;
import com.example.etudiants.entities.Departement;
import com.example.etudiants.entities.Etudiant;


public interface EtudiantService {
	
	EtudiantDTO updateEtudiant(EtudiantDTO e);
	void deleteEtudiant(Etudiant e);
	void deleteEtudiantById(Long id);

	Page<Etudiant> getAllEtudiantsParPage(int page, int size);
	
	List<Etudiant> findByNom(String nom);
	List<Etudiant> findByNomContains(String nom);
	List<Etudiant> findByNomPrenom (String nom, String prenom);
	List<Etudiant> findByDepartement (Departement departement);
	List<Etudiant> findByDepartementIdDepart(Long idDepart);
	List<Etudiant> findByOrderByNom();
	List<Etudiant> trierEtudiantsNomPrenom ();
	EtudiantDTO convertEntityToDto (Etudiant etudiant);
	Etudiant convertDtoToEntity(EtudiantDTO etudiantDto);
	
	EtudiantDTO saveEtudiant(EtudiantDTO e);
	EtudiantDTO getEtudiant(Long id);
	List<EtudiantDTO> getAllEtudiants();


}
