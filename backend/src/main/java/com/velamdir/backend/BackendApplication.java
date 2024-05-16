package com.velamdir.backend;

import com.velamdir.backend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootApplication
@RestController
@RequestMapping("/image")
public class BackendApplication {
	@Autowired
    private StorageService service;

	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		String uploadImage = service.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	@GetMapping("/{}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
      byte imageData[] = service.downloadImage(fileName);
	  return ResponseEntity.status(HttpStatus.OK)
			  .contentType(MediaType.valueOf("image/png"))
			  .body(imageData);
	}

	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);

		public RestTemplate restTemplate(){
			RestTemplate restTemplate= new RestTemplate();
			restTemplate.getInterceptors().add(((request, body, execution) -> {}))
		}
	}

}
