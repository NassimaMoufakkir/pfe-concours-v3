package com.fstg.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bean.TypeDiplome;
import com.fstg.service.facade.TypeDiplomeService;

@RestController
@RequestMapping("pfe-concours-v2-api/type-diplome")
public class TypeDiplomeRest {
	@Autowired
	private TypeDiplomeService typeDiplomeService;

	@GetMapping("libelle/{libelle}")
	public TypeDiplome findByLibelle(@PathVariable String libelle) {
		return typeDiplomeService.findByLibelle(libelle);
	}

	@GetMapping("/")
	public List<TypeDiplome> findAll() {
		return typeDiplomeService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody TypeDiplome typeDiplome) {
		return typeDiplomeService.save(typeDiplome);
	}

}