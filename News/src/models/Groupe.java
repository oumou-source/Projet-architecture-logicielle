package models;

// Generated 25 d�c. 2014 13:37:41 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
 * Groupe generated by hbm2java
 */
@Entity
@Table(name = "groupe", catalog = "news")
public class Groupe implements java.io.Serializable {

	private Integer id;
	private String nom;
	private String description;
	private int etat;

	private int supprime;

	private List<User> listPersonnels = new ArrayList<User>();
	private List<Fonctionnalite> listeFonctionnalite = new ArrayList<Fonctionnalite>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nom", nullable = false, length = 100)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "description", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "etat", nullable = false, length = 50)
	public int getEtat() {
		return this.etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	@OneToMany(mappedBy="groupe")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<User> getListPersonnels() {
		return listPersonnels;
	}

	public void setListPersonnels(List<User> listPersonnels) {
		this.listPersonnels = listPersonnels;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "fonctionnalitegroupe", catalog = "ges_trans", joinColumns = { 
			@JoinColumn(name = "idGroupe", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idFonctionnalite", nullable = false, updatable = false) })
	public List<Fonctionnalite> getListeFonctionnalite() {
		return listeFonctionnalite;
	}

	public void setListeFonctionnalite(List<Fonctionnalite> listeFonctionnalite) {
		this.listeFonctionnalite = listeFonctionnalite;
	}

	@Column(name = "supprime")
	public int getSupprime() {
		return supprime;
	}

	public void setSupprime(int supprime) {
		this.supprime = supprime;
	}
	

}
