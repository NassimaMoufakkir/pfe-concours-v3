package com.fstg.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String login;
	private String nom;
	private String prénom;
	private String password;
	private boolean bloqued;
	private int nbrTentativeRestant;
	private String email;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dateBloquage;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrénom() {
		return prénom;
	}

	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isBloqued() {
		return bloqued;
	}

	public void setBloqued(boolean bloqued) {
		this.bloqued = bloqued;
	}

	public int getNbrTentativeRestant() {
		return nbrTentativeRestant;
	}

	public void setNbrTentativeRestant(int nbrTentativeRestant) {
		this.nbrTentativeRestant = nbrTentativeRestant;
	}

	public Date getDateBloquage() {
		return dateBloquage;
	}

	public void setDateBloquage(Date dateBloquage) {
		this.dateBloquage = dateBloquage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.AgenceLocation.bean.User[ id=" + id + " ]";
	}

}
