package com.fstg.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.bean.Departement;
import com.fstg.dao.DepartementDao;
import com.fstg.service.facade.DepartementService;
import com.fstg.service.facade.FiliereService;

@Service
public class DepartementServiceImpl implements DepartementService {

	@Autowired
	private DepartementDao departementDao;
	@Autowired
	private FiliereService filiereService;

	@Override
	public Departement findByReference(String reference) {
		return departementDao.findByReference(reference);
	}

	@Override
	public List<Departement> findAll() {
		return departementDao.findAll();
	}

	@Override
	public int save(Departement departement) {
		Departement foundedDepartement = findByReference(departement.getReference());
		if (foundedDepartement != null) {
			return -1;
		} else {
			departementDao.save(departement);
			filiereService.save(departement, departement.getFilieres());
			return 1;
		}
	}

	@Override
	@Transactional
	public int deleteByReference(String reference) {
		Departement foundedDepartement = findByReference(reference);
		if (foundedDepartement != null) {
			int res1 = filiereService.deleteByDepartementReference(reference);
			int res2 = departementDao.deleteByReference(reference);
			return res1 + res2;
		} else {
			return -1;
		}
	}
}