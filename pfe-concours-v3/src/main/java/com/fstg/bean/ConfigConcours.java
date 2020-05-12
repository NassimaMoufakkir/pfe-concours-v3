package com.fstg.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ConfigConcours implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double noteMin;
	private double nbreMaxAdmis;
	private double nbreMaxEcritAdmis;
	private double nbreMaxOraleAdmis;
	@ManyToOne
	private TypeDiplome typeDiplome;
	@ManyToOne
	private Concours concours;

	public ConfigConcours() {
		super();
	}

	public ConfigConcours(Long id, double noteMin, double nbreMaxAdmis, double nbreMaxEcritAdmis,
			double nbreMaxOraleAdmis, TypeDiplome typeDiplome, Concours concours) {
		super();
		this.id = id;
		this.noteMin = noteMin;
		this.nbreMaxAdmis = nbreMaxAdmis;
		this.nbreMaxEcritAdmis = nbreMaxEcritAdmis;
		this.nbreMaxOraleAdmis = nbreMaxOraleAdmis;
		this.typeDiplome = typeDiplome;
		this.concours = concours;
	}

	public TypeDiplome getTypeDiplome() {
		return typeDiplome;
	}

	public void setTypeDiplome(TypeDiplome typeDiplome) {
		this.typeDiplome = typeDiplome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getNoteMin() {
		return noteMin;
	}

	public void setNoteMin(double noteMin) {
		this.noteMin = noteMin;
	}

	public double getNbreMaxAdmis() {
		return nbreMaxAdmis;
	}

	public void setNbreMaxAdmis(double nbreMaxAdmis) {
		this.nbreMaxAdmis = nbreMaxAdmis;
	}

	public double getNbreMaxEcritAdmis() {
		return nbreMaxEcritAdmis;
	}

	public void setNbreMaxEcritAdmis(double nbreMaxEcritAdmis) {
		this.nbreMaxEcritAdmis = nbreMaxEcritAdmis;
	}

	public double getNbreMaxOraleAdmis() {
		return nbreMaxOraleAdmis;
	}

	public void setNbreMaxOraleAdmis(double nbreMaxOraleAdmis) {
		this.nbreMaxOraleAdmis = nbreMaxOraleAdmis;
	}

	public Concours getConcours() {
		return concours;
	}

	public void setConcours(Concours concours) {
		this.concours = concours;
	}

}
