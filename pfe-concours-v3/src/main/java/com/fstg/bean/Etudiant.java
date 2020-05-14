package com.fstg.bean;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Etudiant implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cne;
	private String cin;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	@Temporal(TemporalType.DATE)
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateNaissance;
	private double noteS1;
	private double noteS2;
	private double noteS3;
	private double noteS4;
	private double moyenneBac;
	@ManyToOne
	private TypeDiplome typeDiplome;
	@OneToMany(mappedBy = "etudiant")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Inscription> inscriptions;
	private File imageBac;
	private File imageS1;
	private File imageS2;
	private File imageS3;
	private File imageS4;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(Long id, String cne, String cin, String nom, String prenom, String email, String telephone,
			Date dateNaissance, double noteS1, double noteS2, double noteS3, double noteS4, double moyenneBac,
			TypeDiplome typeDiplome, List<Inscription> inscriptions, File imageBac, File imageS1, File imageS2,
			File imageS3, File imageS4) {
		super();
		this.id = id;
		this.cne = cne;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.noteS1 = noteS1;
		this.noteS2 = noteS2;
		this.noteS3 = noteS3;
		this.noteS4 = noteS4;
		this.moyenneBac = moyenneBac;
		this.typeDiplome = typeDiplome;
		this.inscriptions = inscriptions;
		this.imageBac = imageBac;
		this.imageS1 = imageS1;
		this.imageS2 = imageS2;
		this.imageS3 = imageS3;
		this.imageS4 = imageS4;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public double getNoteS1() {
		return noteS1;
	}

	public void setNoteS1(double noteS1) {
		this.noteS1 = noteS1;
	}

	public double getNoteS2() {
		return noteS2;
	}

	public void setNoteS2(double noteS2) {
		this.noteS2 = noteS2;
	}

	public double getNoteS3() {
		return noteS3;
	}

	public void setNoteS3(double noteS3) {
		this.noteS3 = noteS3;
	}

	public double getNoteS4() {
		return noteS4;
	}

	public void setNoteS4(double noteS4) {
		this.noteS4 = noteS4;
	}

	public double getMoyenneBac() {
		return moyenneBac;
	}

	public void setMoyenneBac(double moyenneBac) {
		this.moyenneBac = moyenneBac;
	}

	public TypeDiplome getTypeDiplome() {
		return typeDiplome;
	}

	public void setTypeDiplome(TypeDiplome typeDiplome) {
		this.typeDiplome = typeDiplome;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public File getImageBac() {
		return imageBac;
	}

	public void setImageBac(File imageBac) {
		this.imageBac = imageBac;
	}

	public File getImageS1() {
		return imageS1;
	}

	public void setImageS1(File imageS1) {
		this.imageS1 = imageS1;
	}

	public File getImageS2() {
		return imageS2;
	}

	public void setImageS2(File imageS2) {
		this.imageS2 = imageS2;
	}

	public File getImageS3() {
		return imageS3;
	}

	public void setImageS3(File imageS3) {
		this.imageS3 = imageS3;
	}

	public File getImageS4() {
		return imageS4;
	}

	public void setImageS4(File imageS4) {
		this.imageS4 = imageS4;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		result = prime * result + ((cne == null) ? 0 : cne.hashCode());
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imageBac == null) ? 0 : imageBac.hashCode());
		result = prime * result + ((imageS1 == null) ? 0 : imageS1.hashCode());
		result = prime * result + ((imageS2 == null) ? 0 : imageS2.hashCode());
		result = prime * result + ((imageS3 == null) ? 0 : imageS3.hashCode());
		result = prime * result + ((imageS4 == null) ? 0 : imageS4.hashCode());
		result = prime * result + ((inscriptions == null) ? 0 : inscriptions.hashCode());
		long temp;
		temp = Double.doubleToLongBits(moyenneBac);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		temp = Double.doubleToLongBits(noteS1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(noteS2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(noteS3);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(noteS4);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((typeDiplome == null) ? 0 : typeDiplome.hashCode());
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
		Etudiant other = (Etudiant) obj;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		if (cne == null) {
			if (other.cne != null)
				return false;
		} else if (!cne.equals(other.cne))
			return false;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imageBac == null) {
			if (other.imageBac != null)
				return false;
		} else if (!imageBac.equals(other.imageBac))
			return false;
		if (imageS1 == null) {
			if (other.imageS1 != null)
				return false;
		} else if (!imageS1.equals(other.imageS1))
			return false;
		if (imageS2 == null) {
			if (other.imageS2 != null)
				return false;
		} else if (!imageS2.equals(other.imageS2))
			return false;
		if (imageS3 == null) {
			if (other.imageS3 != null)
				return false;
		} else if (!imageS3.equals(other.imageS3))
			return false;
		if (imageS4 == null) {
			if (other.imageS4 != null)
				return false;
		} else if (!imageS4.equals(other.imageS4))
			return false;
		if (inscriptions == null) {
			if (other.inscriptions != null)
				return false;
		} else if (!inscriptions.equals(other.inscriptions))
			return false;
		if (Double.doubleToLongBits(moyenneBac) != Double.doubleToLongBits(other.moyenneBac))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (Double.doubleToLongBits(noteS1) != Double.doubleToLongBits(other.noteS1))
			return false;
		if (Double.doubleToLongBits(noteS2) != Double.doubleToLongBits(other.noteS2))
			return false;
		if (Double.doubleToLongBits(noteS3) != Double.doubleToLongBits(other.noteS3))
			return false;
		if (Double.doubleToLongBits(noteS4) != Double.doubleToLongBits(other.noteS4))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (typeDiplome == null) {
			if (other.typeDiplome != null)
				return false;
		} else if (!typeDiplome.equals(other.typeDiplome))
			return false;
		return true;
	}

}
