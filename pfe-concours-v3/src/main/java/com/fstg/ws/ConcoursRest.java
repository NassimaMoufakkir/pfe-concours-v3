package com.fstg.ws;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/annee/{annee}")
	public List<Concours> findByAnnee(@PathVariable int annee) {
		return concoursService.findByAnnee(annee);
	}

	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return concoursService.deleteByReference(reference);
	}

	@PutMapping("/id/{id}/reference/{reference}/annee/{annee}/dateOrale/{dateOrale}/dateEcrit/{dateEcrit}/nbreEtudiantAdmisOrale/{nbreEtudiantAdmisOrale}/nbreEtudiantAdmisEcrit/{nbreEtudiantAdmisEcrit}/nbreEtudiantAdmis/{nbreEtudiantAdmis}/description/{description}")
	public Concours update(@PathVariable Long id, @PathVariable String reference, @PathVariable int annee,
			@DateTimeFormat(pattern = "dd-MM-yyyy") Date dateOrale, @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateEcrit, @PathVariable int nbreEtudiantAdmisOrale,
			@PathVariable int nbreEtudiantAdmisEcrit, @PathVariable int nbreEtudiantAdmis,
			@PathVariable String description) {
		return concoursService.update(id, reference, annee, dateOrale, dateEcrit, nbreEtudiantAdmisOrale,
				nbreEtudiantAdmisEcrit, nbreEtudiantAdmis, description);
	}

}
