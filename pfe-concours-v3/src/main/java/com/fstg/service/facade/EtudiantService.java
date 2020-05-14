package com.fstg.service.facade;

import java.util.List;

import com.fstg.bean.Etudiant;

public interface EtudiantService {
	public Etudiant findByCne(String cne);

	public List<Etudiant> findAll();

	public int save(Etudiant etudiant);
	
	public List<Etudiant> findByInscriptionsConcoursReference(String reference);
	
	public int deleteByTypeDiplomeLibelle(String libelle);
	
	
}
