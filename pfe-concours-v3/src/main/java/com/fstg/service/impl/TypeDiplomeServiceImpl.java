package com.fstg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.bean.TypeDiplome;
import com.fstg.dao.TypeDiplomeDao;

import com.fstg.service.facade.TypeDiplomeService;

@Service
public class TypeDiplomeServiceImpl implements TypeDiplomeService {
	@Autowired
	private TypeDiplomeDao typeDiplomeDao;

	@Override
	public TypeDiplome findByLibelle(String libelle) {
		return typeDiplomeDao.findByLibelle(libelle);
	}

	@Override
	public List<TypeDiplome> findAll() {
		return typeDiplomeDao.findAll();
	}

	@Override
	public int save(TypeDiplome typeDiplome) {
		TypeDiplome foundedTypeDiplome = findByLibelle(typeDiplome.getLibelle());
		if (foundedTypeDiplome != null) {
			return -1;
		} else {
			typeDiplomeDao.save(typeDiplome);
			return 1;
		}
	}

}
