package com.fstg.service.facade;

import java.util.List;

import com.fstg.bean.Departement;
import com.fstg.bean.Filiere;

public interface FiliereService {
	public Filiere findByLibelle(String reference);

	public List<Filiere> findByDepartementRefrence(String reference);

	public int deleteByDepartementReference(String reference);

	public int deleteByLibelle(String libelle);

	public List<Filiere> findAll();

	public int save(Departement departement, List<Filiere> filieres);
}
