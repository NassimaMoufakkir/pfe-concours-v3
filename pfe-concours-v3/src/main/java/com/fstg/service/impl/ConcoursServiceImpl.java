package com.fstg.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.bean.Concours;
import com.fstg.dao.ConcoursDao;
import com.fstg.service.facade.ConcoursService;
import com.fstg.service.facade.ConfigConcoursService;
import com.fstg.service.facade.InscriptionService;

@Service
public class ConcoursServiceImpl implements ConcoursService {
	@Autowired
	private ConcoursDao concoursDao;

	@Autowired
	private ConfigConcoursService configConcoursService;

	@Autowired
	private InscriptionService inscriptionService;

	@Override
	public Concours findByReference(String reference) {
		return concoursDao.findByReference(reference);
	}

	@Override
	public List<Concours> findAll() {
		return concoursDao.findAll();
	}

	@Override
	public int save(Concours concours) {
		Concours loadedConcours = findByReference(concours.getReference());
		if (loadedConcours != null) {
			return -1;
		} else {
			concoursDao.save(concours);
			// update
			configConcoursService.save(concours, concours.getConfigConcourss());
			inscriptionService.save(concours, concours.getInscriptions());
		}
		return 1;
	}

	@Override
	@Transactional
	public int deleteByReference(String reference) {
		int resConfig = configConcoursService.deleteByConcoursReference(reference);
		int resConcours = concoursDao.deleteByReference(reference);
		return resConcours + resConfig;
	}

	@Override
	public List<Concours> findByAnnee(int annee) {
		return concoursDao.findByAnnee(annee);
	}

}
