package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String adresse;
	private long telephone;


	@ManyToOne(
			targetEntity =net.guides.springboot2.springboot2jpacrudexample.model.Materiel.class,
			fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			}
	)
	@JoinTable( name = "materiels_clients",
			joinColumns = @JoinColumn( name = "id" ),
			inverseJoinColumns = @JoinColumn( name = "idMateriel" ) )
	private Materiel materiel;

	/*
	@OneToMany(
			fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			}
	)
	@JoinTable(
			name = "categorie_produit",
			joinColumns = @JoinColumn(name = "categorie_id"),
			inverseJoinColumns = @JoinColumn(name = "produit_id")
	)
	private List<Materiel> materiels = new ArrayList<>();

	@ManyToOne
	private Materiel materiel;

	public Materiel getMateriel() {
		return materiel;}
	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;}
*/

	public Client() {

	}
	
	public Client(String firstName, String lastName, String emailId, String adresse, long telephone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "client_adresse", nullable = false)
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "client_telephone", nullable = false)
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName='" + lastName + ", emailId='" + emailId + ", adresse='" + adresse + ", telephone=" + telephone + "]";
	}
}
