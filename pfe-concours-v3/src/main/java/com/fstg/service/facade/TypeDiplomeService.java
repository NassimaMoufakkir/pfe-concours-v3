package com.fstg.service.facade;

import java.util.List;

import com.fstg.bean.TypeDiplome;

public interface TypeDiplomeService {
	public TypeDiplome findByLibelle(String libelle);

	public List<TypeDiplome> findAll();

	public int save(TypeDiplome typeDiplome);

	public int deleteByLibelle(String libelle);

}
