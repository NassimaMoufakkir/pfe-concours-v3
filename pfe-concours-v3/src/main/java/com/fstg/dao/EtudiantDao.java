package com.fstg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.bean.Etudiant;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {

	public Etudiant findByCne(String cne);
	
	public List<Etudiant> findByInscriptionsConcoursReference(String reference);
	
	public int deleteByTypeDiplomeLibelle(String libelle);
}
