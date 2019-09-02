package com.alphonse.canalplus.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_contrat")
public class Contrat implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Long numero;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateDeSignature;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateDeffet;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_abonne", nullable = false)
	private Abonne abonne;

	public Contrat() {
		super();
	}

	public Contrat(Long numero, Date dateDeSignature, Date dateDebut, Date dateDeffet, Abonne abonne) {
		super();
		this.numero = numero;
		this.dateDeSignature = dateDeSignature;
		this.dateDebut = dateDebut;
		this.dateDeffet = dateDeffet;
		this.abonne = abonne;
	}

	public Contrat(Long id, Long numero, Date dateDeSignature, Date dateDebut, Date dateDeffet, Abonne abonne) {
		super();
		this.id = id;
		this.numero = numero;
		this.dateDeSignature = dateDeSignature;
		this.dateDebut = dateDebut;
		this.dateDeffet = dateDeffet;
		this.abonne = abonne;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getDateDeSignature() {
		return dateDeSignature;
	}

	public void setDateDeSignature(Date dateDeSignature) {
		this.dateDeSignature = dateDeSignature;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateDeffet() {
		return dateDeffet;
	}

	public void setDateDeffet(Date dateDeffet) {
		this.dateDeffet = dateDeffet;
	}

	public Abonne getAbonne() {
		return abonne;
	}

	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", numero=" + numero + ", dateDeSignature=" + dateDeSignature + ", dateDebut="
				+ dateDebut + ", dateDeffet=" + dateDeffet + ", abonne=" + abonne + "]";
	}

}
