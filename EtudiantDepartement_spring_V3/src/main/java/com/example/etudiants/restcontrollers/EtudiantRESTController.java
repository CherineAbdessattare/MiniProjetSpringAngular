package com.example.etudiants.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.etudiants.dto.EtudiantDTO;
import com.example.etudiants.entities.Etudiant;
import com.example.etudiants.service.EtudiantService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class EtudiantRESTController {
	
	@Autowired
	EtudiantService etudiantService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<EtudiantDTO> getAllEtudiants() {
	return etudiantService.getAllEtudiants();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public EtudiantDTO getEtudiantById(@PathVariable("id") Long id) {
	return etudiantService.getEtudiant(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public EtudiantDTO createEtudiantt(@RequestBody EtudiantDTO etudiantDTO) {
	return etudiantService.saveEtudiant(etudiantDTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public EtudiantDTO updateEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
	return etudiantService.updateEtudiant(etudiantDTO);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteEtudiant(@PathVariable("id") Long id)
	{
	etudiantService.deleteEtudiantById(id);
	}
	
	@RequestMapping(value="/etudDepart/{idDepart}",method = RequestMethod.GET)
	public List<Etudiant> getEtudiantsByIdDepart(@PathVariable("idDepart") Long idDepart) {
	return etudiantService.findByDepartementIdDepart(idDepart);
	}
	
	@RequestMapping(value="/etudsByName/{nom}",method = RequestMethod.GET)
	public List<Etudiant> findByNomEtudiantContains(@PathVariable("nom") String nom) {
	return etudiantService.findByNomContains(nom);
	}



	

}
