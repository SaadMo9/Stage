package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String adresse;
	private long telephone;

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
