package models;

// Generated 25 d�c. 2014 13:37:41 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.istack.internal.Nullable;

/**
 * Personnel generated by hbm2java
 */
@XmlRootElement 
@Entity
@Table(name = "user", catalog = "news")
public class User implements java.io.Serializable {

	private Integer id;
	private String nomPrenom;
	private String login;
	private String password;
	
	private Groupe groupe = new Groupe();
	private int etat;

	private boolean connected;

	private int supprime;


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nom_prenom", nullable = false, length = 100)
	public String getNomPrenom() {
		return this.nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

	@Column(name = "login", length = 100)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(name = "etat", nullable = false, length = 40)
	public int getEtat() {
		return this.etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	@ManyToOne
	@JoinColumn(name = "groupe")
	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	@Transient
	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	
	@Column(name = "supprime")
	public int getSupprime() {
		return supprime;
	}

	public void setSupprime(int supprime) {
		this.supprime = supprime;
	}


}
