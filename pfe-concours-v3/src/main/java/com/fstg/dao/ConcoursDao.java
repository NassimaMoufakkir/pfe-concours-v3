package com.fstg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.bean.Concours;

@Repository
public interface ConcoursDao extends JpaRepository<Concours, Long> {

	public Concours findByReference(String reference);

}
