package com.velamdir.backend;

import com.velamdir.backend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootApplication
@RestController
@RequestMapping("/image")
public class BackendApplication {

	@Autowired
	private StorageService service;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@PostMapping("/upload-document")
	public ResponseEntity<?> uploadImage(@RequestParam("document") MultipartFile file) throws IOException {
		String uploadImage = service.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK).body("{\"success\": true, \"message\": \"" + uploadImage + "\"}");
	}

	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
		byte[] imageData = service.downloadImage(fileName);
		if (imageData != null) {
			return ResponseEntity.status(HttpStatus.OK)
					.contentType(MediaType.IMAGE_PNG)
					.body(imageData);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found");
		}
	}
}
