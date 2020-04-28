package com.fstg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.bean.Etudiant;
import com.fstg.bean.TypeDiplome;
import com.fstg.dao.EtudiantDao;
import com.fstg.service.facade.EtudiantService;
import com.fstg.service.facade.InscriptionService;
import com.fstg.service.facade.TypeDiplomeService;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	@Autowired
	private EtudiantDao etudiantDao;

	@Autowired
	private InscriptionService inscriptionService;

	@Autowired
	private TypeDiplomeService typeDiplomeService;

	@Override
	public Etudiant findByCne(String cne) {
		return etudiantDao.findByCne(cne);
	}

	@Override
	public List<Etudiant> findAll() {
		return etudiantDao.findAll();
	}

	@Override
	public int save(Etudiant etudiant) {
		Etudiant loadedEtudiant = findByCne(etudiant.getCne());
		TypeDiplome loadedTypeDiplome = typeDiplomeService.findByLibelle(etudiant.getTypeDiplome().getLibelle());
		if (loadedEtudiant != null) {
			return -1;
		}
		if (loadedTypeDiplome == null) {
			return -2;
		} else {
			etudiant.setTypeDiplome(loadedTypeDiplome);
			etudiantDao.save(etudiant);
			inscriptionService.save(etudiant, etudiant.getInscriptions());
		}
		return 0;
	}

	@Override
	public List<Etudiant> findByInscriptionsConcoursReference(String reference) {
		return etudiantDao.findByInscriptionsConcoursReference(reference);
	}

}
