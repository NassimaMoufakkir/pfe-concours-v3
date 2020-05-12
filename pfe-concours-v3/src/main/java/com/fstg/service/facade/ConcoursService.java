package com.fstg.service.facade;

import java.util.List;

import com.fstg.bean.Concours;

public interface ConcoursService {
	public Concours findByReference(String reference);

	public List<Concours> findAll();

	public int save(Concours concours);

	public List<Concours> findByAnnee(int annee);

	public int deleteByReference(String reference);

}
