package com.alphonse.canalplus.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class DetailsPersonne {
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;
	@Column(nullable = false)
	private String prefixeNumTelephonePortable;
	private String prefixeNumTelephoneFixe;
	@Column(nullable = false)
	private Long numTelephonePortable;
	private Long numTelephoneFixe;

	public DetailsPersonne() {
		super();
	}

	public DetailsPersonne(String nom, String prenom, Date dateDeNaissance, String prefixeNumTelephonePortable,
			String prefixeNumTelephoneFixe, Long numTelephonePortable, Long numTelephoneFixe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.prefixeNumTelephonePortable = prefixeNumTelephonePortable;
		this.prefixeNumTelephoneFixe = prefixeNumTelephoneFixe;
		this.numTelephonePortable = numTelephonePortable;
		this.numTelephoneFixe = numTelephoneFixe;
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

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Long getNumTelephonePortable() {
		return numTelephonePortable;
	}

	public String getPrefixeNumTelephonePortable() {
		return prefixeNumTelephonePortable;
	}

	public void setPrefixeNumTelephonePortable(String prefixeNumTelephonePortable) {
		this.prefixeNumTelephonePortable = prefixeNumTelephonePortable;
	}

	public String getPrefixeNumTelephoneFixe() {
		return prefixeNumTelephoneFixe;
	}

	public void setPrefixeNumTelephoneFixe(String prefixeNumTelephoneFixe) {
		this.prefixeNumTelephoneFixe = prefixeNumTelephoneFixe;
	}

	public void setNumTelephonePortable(Long numTelephonePortable) {
		this.numTelephonePortable = numTelephonePortable;
	}

	public Long getNumTelephoneFixe() {
		return numTelephoneFixe;
	}

	public void setNumTelephoneFixe(Long numTelephoneFixe) {
		this.numTelephoneFixe = numTelephoneFixe;
	}

	@Override
	public String toString() {
		return "DetailsPersonne [nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance
				+ ", numTelephonePortable=" + numTelephonePortable + ", numTelephoneFixe=" + numTelephoneFixe + "]";
	}

}
