package com.example.etudiants.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.etudiants.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
	
}

