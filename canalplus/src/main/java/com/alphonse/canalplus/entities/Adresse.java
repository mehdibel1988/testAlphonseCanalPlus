package com.alphonse.canalplus.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "t_adresse")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Adresse implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Integer num;
	@Column(nullable = false)
	private String rue;
	@Column(nullable = false)
	private String ville;
	@Column(nullable = false)
	private Integer codePostal;
	@Column(nullable = false)
	private String pays;
	@Column(length = 3000)
	private String complement;

	public Adresse() {
		super();
	}

	public Adresse(Long id, Integer num, String rue, String ville, Integer codePostal, String pays) {
		super();
		this.id = id;
		this.num = num;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
	}

	public Adresse(Integer num, String rue, String ville, Integer codePostal, String pays) {
		super();
		this.num = num;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", num=" + num + ", rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal
				+ ", pays=" + pays + "]";
	}

}
