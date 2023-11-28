package com.example.etudiants.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nom", types = {Etudiant.class })
public interface EtudiantProjection {
public String getNom();
}
