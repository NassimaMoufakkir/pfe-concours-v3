package com.fstg.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Concours implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private String description;

	private int annee;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateConcours;
	@OneToMany(mappedBy = "concours")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Inscription> inscriptions;
	@OneToMany(mappedBy = "concours")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<ConfigConcours> configConcourss = new ArrayList<ConfigConcours>();

	public Concours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Concours(Long id, String reference, String description, Date dateConcours, List<Inscription> inscriptions,
			List<ConfigConcours> configConcourss) {
		super();
		this.id = id;
		this.reference = reference;
		this.description = description;
		this.dateConcours = dateConcours;
		this.inscriptions = inscriptions;
		this.configConcourss = configConcourss;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateConcours == null) ? 0 : dateConcours.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concours other = (Concours) obj;
		if (dateConcours == null) {
			if (other.dateConcours != null)
				return false;
		} else if (!dateConcours.equals(other.dateConcours))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateConcours() {
		return dateConcours;
	}

	public void setDateConcours(Date dateConcours) {
		this.dateConcours = dateConcours;
	}

	public List<ConfigConcours> getConfigConcourss() {
		return configConcourss;
	}

	public void setConfigConcourss(List<ConfigConcours> configConcourss) {
		this.configConcourss = configConcourss;
	}

}