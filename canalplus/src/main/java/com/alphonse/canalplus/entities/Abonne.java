package com.alphonse.canalplus.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author am
 *
 */
@Entity
@Table(name = "t_abonne")
public class Abonne implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Long numAbonnement;
	@Embedded
	private DetailsPersonne detail;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_adresse", nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Adresse adresse;

	public Abonne() {
		super();

	}

	public Abonne(Long id, Long numAbonnement, DetailsPersonne detail, Adresse adresse) {
		super();
		this.id = id;
		this.numAbonnement = numAbonnement;
		this.detail = detail;
		this.adresse = adresse;
	}

	public Abonne(Long numAbonnement, DetailsPersonne detail, Adresse adresse) {
		super();
		this.numAbonnement = numAbonnement;
		this.detail = detail;
		this.adresse = adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumAbonnement() {
		return numAbonnement;
	}

	public void setNumAbonnement(Long numAbonnement) {
		this.numAbonnement = numAbonnement;
	}

	public DetailsPersonne getDetail() {
		return detail;
	}

	public void setDetail(DetailsPersonne detail) {
		this.detail = detail;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Abonne [id=" + id + ", numAbonnement=" + numAbonnement + ", detail=" + detail + ", adresse=" + adresse
				+ "]";
	}

}
