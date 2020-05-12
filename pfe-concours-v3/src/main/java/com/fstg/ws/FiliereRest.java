package com.fstg.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bean.Departement;
import com.fstg.bean.Filiere;
import com.fstg.service.facade.FiliereService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/filiere")
public class FiliereRest {
	@Autowired
    private FiliereService filiereService;

	@GetMapping("/libelle/{libelle}")
	public Filiere findByLibelle(@PathVariable String reference) {
		return filiereService.findByLibelle(reference);
	}

	@DeleteMapping("/departement/reference/{reference}")
	public List<Filiere> findByDepartementRefrence(@PathVariable String reference) {
		return filiereService.findByDepartementRefrence(reference);
	}

	public int deleteByDepartementReference(@PathVariable String reference) {
		return filiereService.deleteByDepartementReference(reference);
	}

	public int deleteByLibelle(@PathVariable String libelle) {
		return filiereService.deleteByLibelle(libelle);
	}

	@GetMapping("/")
	public List<Filiere> findAll() {
		return filiereService.findAll();
	}

	public int save(Departement departement, List<Filiere> filieres) {
		return filiereService.save(departement, filieres);
	}
    
    
}