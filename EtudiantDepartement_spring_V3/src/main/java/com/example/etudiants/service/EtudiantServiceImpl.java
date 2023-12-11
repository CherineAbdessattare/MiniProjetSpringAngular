package com.example.etudiants.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.etudiants.dto.EtudiantDTO;
import com.example.etudiants.entities.Departement;
import com.example.etudiants.entities.Etudiant;
import com.example.etudiants.repos.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService{
	
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Override
	public EtudiantDTO saveEtudiant(EtudiantDTO e) {
		return convertEntityToDto(etudiantRepository.save(convertDtoToEntity(e)));
	}

	@Override
	public EtudiantDTO updateEtudiant(EtudiantDTO e) {
		return convertEntityToDto(etudiantRepository.save(convertDtoToEntity(e)));
	}

	@Override
	public void deleteEtudiant(Etudiant e) {
		etudiantRepository.delete(e);
		
	}

	@Override
	public void deleteEtudiantById(Long id) {
		etudiantRepository.deleteById(id);
		
	}

	@Override
	public EtudiantDTO getEtudiant(Long id) {
		return convertEntityToDto(etudiantRepository.findById(id).get());
	}

	@Override
	public List<EtudiantDTO> getAllEtudiants() {
		return etudiantRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
				//OU BIEN
				/*List<Produit> prods = produitRepository.findAll();
				List<ProduitDTO> listprodDto = new ArrayList<>(prods.size());
				for (Produit p : prods)
				listprodDto.add(convertEntityToDto(p));
				return listprodDto;*/
				}

	@Override
	public Page<Etudiant> getAllEtudiantsParPage(int page, int size) {
		return etudiantRepository.findAll(PageRequest.of(page, size));

	}@Override
	public List<Etudiant> findByNom(String nom) {
		return etudiantRepository.findByNom(nom);
	}

	@Override
	public List<Etudiant> findByNomContains(String nom) {
		return etudiantRepository.findByNomContains(nom);
	}

	@Override
	public List<Etudiant> findByNomPrenom(String nom, String prenom) {
		return etudiantRepository.findByNomPrenom(nom, prenom);
	}

	@Override
	public List<Etudiant> findByDepartement(Departement departement) {
		return etudiantRepository.findByDepartement(departement);
	}

	@Override
	public List<Etudiant> findByDepartementIdDepart(Long idDepart) {
		return etudiantRepository.findByDepartementIdDepart(idDepart);
	}

	@Override
	public List<Etudiant> findByOrderByNom() {
		return etudiantRepository.findByOrderByNom();
	}

	@Override
	public List<Etudiant> trierEtudiantsNomPrenom() {
		return etudiantRepository.trierEtudiantsNomPrenom();
	}
	
	@Override
	public EtudiantDTO convertEntityToDto(Etudiant etudiant) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		EtudiantDTO etudiantDTO = modelMapper.map(etudiant, EtudiantDTO.class);
		 return etudiantDTO; 
		
		
		/*
		 * EtudiantDTO etudiantDTO = new EtudiantDTO();
		 * etudiantDTO.setIdEtudiant(etudiant.getIdEtudiant());
		 * etudiantDTO.setNom(etudiant.getNom());
		 * etudiantDTO.setPrenom(etudiant.getPrenom());
		 * etudiantDTO.setParcours(etudiant.getParcours());
		 * etudiantDTO.setDateInscription(etudiant.getDateInscription());
		 * etudiantDTO.setEmail(etudiant.getEmail());
		 * etudiantDTO.setDepartement(etudiant.getDepartement()); return etudiantDTO;
		 */
	 
	 /*return ProduitDTO.builder()
	.idProduit(produit.getIdProduit())
	.nomProduit(produit.getNomProduit())
	.prixProduit(produit.getPrixProduit())
	.dateCreation(p.getDateCreation())
	.categorie(produit.getCategorie())
	.build();*/
	}
	
	@Override
	public Etudiant convertDtoToEntity(EtudiantDTO etudiantDto) {
		
		Etudiant etudiant = new Etudiant();
		etudiant = modelMapper.map(etudiantDto, Etudiant.class);
		return etudiant;
		/*
		 * Etudiant etudiant = new Etudiant();
		 * etudiant.setIdEtudiant(etudiantDto.getIdEtudiant());
		 * etudiant.setNom(etudiantDto.getNom());
		 * etudiant.setPrenom(etudiantDto.getPrenom());
		 * etudiant.setDateInscription(etudiantDto.getDateInscription());
		 * etudiant.setEmail(etudiantDto.getEmail());
		 * etudiant.setParcours(etudiantDto.getParcours());
		 * etudiant.setDepartement(etudiantDto.getDepartement()); return etudiant;
		 */
	}
	

	
	

}
