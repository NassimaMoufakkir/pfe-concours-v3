package com.fstg.service.facade;

import java.util.List;

import com.fstg.bean.Departement;

public interface DepartementService {
	public int save(Departement departement);

	public Departement findByReference(String reference);

	public List<Departement> findAll();

	public int deleteByReference(String reference);
}