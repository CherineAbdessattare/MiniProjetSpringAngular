package com.example.etudiants;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.etudiants.entities.Departement;
import com.example.etudiants.entities.Etudiant;
import com.example.etudiants.repos.EtudiantRepository;
import com.example.etudiants.service.EtudiantService;

@SpringBootTest
class EtudiantDepartementApplicationTests {
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private EtudiantService etudiantService;
	@Test
	public void testCreateEtudiant() {
		Departement departement = new Departement();
	    departement.setIdDepart(1L);
		Etudiant etud = new Etudiant("Cherine","Abdessattare",new Date(),"DSI",departement,"shirine073@gmail.com");	
		etudiantRepository.save(etud);
	}
	
	@Test
	public void testFindEtudiant() {
		Etudiant e = etudiantRepository.findById(1L).get();
		System.out.println(e);
	}
	
	@Test
	public void testUpdateEtudiant()
	{
	Etudiant e = etudiantRepository.findById(1L).get();
	e.setNom("Cherine");
	e.setPrenom("Abdessattare");
	etudiantRepository.save(e);
	}
	
	@Test
	public void testdeleteEtudiant() {
		etudiantRepository.deleteById(1L);
	}
	
	@Test
	public void testListerTousEtudiants() {
		List<Etudiant> etuds = etudiantRepository.findAll();
		for (Etudiant e : etuds)
		{
		System.out.println(e);
		}

	}
	
	@Test
	public void testFindByNomEtudiantContains()
	{
	Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(0,2);
	System.out.println(etuds.getSize());
	System.out.println(etuds.getTotalElements());
	System.out.println(etuds.getTotalPages());
	etuds.getContent().forEach(e -> {System.out.println(e.toString());
	 });
	/*ou bien
	for (Etudiant e : etuds)
	{
	System.out.println(e);
	} */
	}
	
	@Test
	public void testFindEtudiantByPrenom() {
		List<Etudiant> etuds = etudiantRepository.findByNom("Abdessattare");
		for (Etudiant e : etuds)
		{
		System.out.println(e);
		}


	}
	@Test
	public void testFindByPrenomContains ()
	{
	List<Etudiant> etuds=etudiantRepository.findByNomContains("A");
	for (Etudiant e : etuds)
	{
		System.out.println(e);
	} 
	}
	
	@Test
	public void testfindByNomPrenom()
	{
	List<Etudiant> etuds = etudiantRepository.findByNomPrenom("Cherine", "Abdessattare");
	for (Etudiant e : etuds)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void testfindByDepartement()
	{
	Departement dep = new Departement();
	dep.setIdDepart(1L);
	List<Etudiant> etuds = etudiantRepository.findByDepartement(dep);
	for (Etudiant e: etuds)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void findByDepartementIdDepart()
	{
	List<Etudiant> etuds = etudiantRepository.findByDepartementIdDepart(1L);
	for (Etudiant e: etuds)
	{
	System.out.println(e);
	}
	 }
	
	@Test
	public void testfindByOrderByNom()
	{
		List<Etudiant> etuds = etudiantRepository.findByOrderByNom();
		for (Etudiant e: etuds)
		{
		System.out.println(e);
		}
	}
	
	@Test
	public void testtrierEtudiantsNomPrenom()
	{
		List<Etudiant> etuds = etudiantRepository.trierEtudiantsNomPrenom();
		for (Etudiant e: etuds)
		{
		System.out.println(e);
		}
	}

}
