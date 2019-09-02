package com.alphonse.canalplus.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_mouvement")
public class Mouvement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String libelle;
	@Column(nullable = false)
	private String desciption;

	public Mouvement() {
		super();
	}

	public Mouvement(Long id, String libelle, String desciption) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.desciption = desciption;
	}

	public Mouvement(String libelle, String desciption) {
		super();
		this.libelle = libelle;
		this.desciption = desciption;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	@Override
	public String toString() {
		return "Mouvement [id=" + id + ", libelle=" + libelle + ", desciption=" + desciption + "]";
	}

}
