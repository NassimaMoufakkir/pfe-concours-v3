package com.fstg.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bean.Concours;
import com.fstg.bean.ConfigConcours;
import com.fstg.service.facade.ConfigConcoursService;


@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/config-concours")
public class ConfigConcoursRest {
	@Autowired
	public ConfigConcoursService configConcoursService;

	@GetMapping("/")
	public List<ConfigConcours> findAll() {
		return configConcoursService.findAll();
	}

	@GetMapping("/concours/reference/{reference}")
	public List<ConfigConcours> findByConcoursReference(@PathVariable String reference) {
		return configConcoursService.findByConcoursReference(reference);
	}

	@GetMapping("/type-diplome/libelle/{libelle}")
	public ConfigConcours findByTypeDiplomeLibelle(@PathVariable String libelle) {
		return configConcoursService.findByTypeDiplomeLibelle(libelle);
	}

	@PostMapping("/")
	public void save(Concours concours, List<ConfigConcours> configConcourss) {
		configConcoursService.save(concours, configConcourss);
	}

	/*@GetMapping("/validate")
	public boolean validateConfigConcours(@RequestBody Concours concours, List<ConfigConcours> configConcourss) {
		return configConcoursService.validateConfigConcours(concours, configConcourss);
	}*/

	@PutMapping("/")
	public int deleteByConcoursReference(@PathVariable String reference) {
		return configConcoursService.deleteByConcoursReference(reference);
	}

	/*@PostMapping("/")
	public int save(ConfigConcours configConcours) {
		return configConcoursService.save(configConcours);
	}*/

	@GetMapping("/concours/reference/{reference}/type-diplome/libelle/{libelle}")
	public ConfigConcours findByConcoursReferenceAndTypeDiplomeLibelle(@PathVariable String reference,
			@PathVariable String libelle) {
		return configConcoursService.findByConcoursReferenceAndTypeDiplomeLibelle(reference, libelle);
	}

	@DeleteMapping("/type-diplome/libelle/{libelle}")
	public int deleteByTypeDiplomeLibelle(@PathVariable String libelle) {
		return configConcoursService.deleteByTypeDiplomeLibelle(libelle);
	}

}

