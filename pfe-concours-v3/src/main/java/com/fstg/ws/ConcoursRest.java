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
import com.fstg.service.facade.ConcoursService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/concours")
public class ConcoursRest {

	@Autowired
	private ConcoursService concoursService;

	@GetMapping("reference/{reference}")
	public Concours findByReference(@PathVariable String reference) {
		return concoursService.findByReference(reference);
	}

	@GetMapping("/")
	public List<Concours> findAll() {
		return concoursService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Concours concours) {
		return concoursService.save(concours);
	}

}
