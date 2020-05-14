package com.fstg.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bean.Etudiant;
import com.fstg.service.facade.EtudiantService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/etudiant")
public class EtudiantRest {

	@Autowired
	private EtudiantService etudiantService;

	@GetMapping("cne/{cne}")
	public Etudiant findByCne(@PathVariable String cne) {
		return etudiantService.findByCne(cne);
	}

	@PostMapping("/")
	public int save(@RequestBody Etudiant etudiant) {
		return etudiantService.save(etudiant);
	}

	@GetMapping("/")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}

	@GetMapping("reference/{reference}")
	public List<Etudiant> findByInscriptionsConcoursReference(@PathVariable String reference) {
		return etudiantService.findByInscriptionsConcoursReference(reference);
	}
	
	@DeleteMapping("/type-diplome/libelle/{libelle}")
	public int deleteByTypeDiplomeLibelle(@PathVariable String libelle) {
		return etudiantService.deleteByTypeDiplomeLibelle(libelle);
	}

	
}