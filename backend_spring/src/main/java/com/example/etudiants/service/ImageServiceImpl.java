package com.example.etudiants.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import org.springframework.http.MediaType;
import com.example.etudiants.entities.Image;
import com.example.etudiants.entities.Etudiant;
import com.example.etudiants.repos.EtudiantRepository;
import com.example.etudiants.repos.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	EtudiantService etudiantService;

	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		/*
		 * Ce code commenté est équivalent au code utilisant le design pattern Builder
		 * Image image = new Image(null, file.getOriginalFilename(),
		 * file.getContentType(), file.getBytes(), null); return
		 * imageRepository.save(image);
		 */
		return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(file.getBytes()).build());
	}

	@Override
	public Image getImageDetails(Long idImage) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(idImage);
		if  (!dbImage.isPresent())
		{System.out.println("pas image "+idImage);
		  return null;
		}
		
		return Image.builder().
				idImage(dbImage.get().getIdImage()).
				name(dbImage.get().getName())
				.type(dbImage.get().getType()).
				image(dbImage.get().getImage()).build();
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
				.body(dbImage.get().getImage());
	}

	@Override
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}
	
	@Override
	public Image uplaodImageEtud(MultipartFile file,Long idEtud) throws IOException {
	Etudiant e = new Etudiant();
	e.setIdEtudiant(idEtud);
	return imageRepository.save(Image.builder().name(file.getOriginalFilename()).
			type(file.getContentType()).
			image(file.getBytes()).
			etudiant(e).build() );
	}
	
	@Override
	public List<Image> getImagesParEtud(Long etudId) {
	Etudiant e = etudiantRepository.findById(etudId).get();
	return e.getImages();
	}


}
