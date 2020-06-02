package com.fstg.ws;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fstg.bean.Etudiant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cet Endpoint permet de gérer les demandes du document")
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/file-uploader")
@RestController
public class FileUploader {

	List<String> files = new ArrayList<String>();
	//Path to save the file
	private final Path rootLocation = Paths.get("C:/Users/hp/Desktop/files");

	@ApiOperation("Cette méthode de télécharger un fichier")
	@PostMapping("/savefile")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, Etudiant etudiant) {
		String message;
		try {
			try {
				Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getResource().getFilename() + ".png"));
				//Files.copy(file.getInputStream(), this.rootLocation.resolve(etudiant.getCne() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("FAIL!");
			}
			files.add(file.getOriginalFilename());

			message = "Successfully uploaded!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Failed to upload!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
}