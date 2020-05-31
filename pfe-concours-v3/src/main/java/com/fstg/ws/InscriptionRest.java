package com.fstg.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bean.Concours;
import com.fstg.bean.Etudiant;
import com.fstg.bean.Inscription;
import com.fstg.service.facade.InscriptionService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/inscription")
public class InscriptionRest {

	@Autowired
	private InscriptionService inscriptionService;

	@GetMapping("reference/{reference}")
	public Inscription findByReference(@PathVariable String reference) {
		return inscriptionService.findByReference(reference);
	}

	@GetMapping("/")
	public List<Inscription> findAll() {
		return inscriptionService.findAll();
	}

	@GetMapping("concours/reference/{reference}")
	public List<Inscription> findByConcoursReference(@PathVariable String reference) {
		return inscriptionService.findByConcoursReference(reference);
	}
	
	@GetMapping("concours/description/{description}")
	public List<Inscription> findByConcoursDescription(@PathVariable String description){
		 return inscriptionService.findByConcoursDescription(description);
	}
	
	@GetMapping("concours/{id}")
	public List<Inscription> findByConcoursReference(@PathVariable Long id) {
		return inscriptionService.findByConcoursId(id);
	}

	@PostMapping("/")
	public int save(@RequestBody Inscription inscription) {
		return inscriptionService.save(inscription);
	}

	public int save(Concours concours, List<Inscription> inscriptions) {
		return inscriptionService.save(concours, inscriptions);
	}

	public int save(@RequestBody Etudiant etudiant) {
		return inscriptionService.save(etudiant, etudiant.getInscriptions());
	}

}
