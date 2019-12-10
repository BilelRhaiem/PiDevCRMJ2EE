package model;

import java.io.Serializable;
import javax.persistence.*;


import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Clients database table.
 * 
 */
@Entity
@Table(name="Clients")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	
	
	
	
	
	public Client(Date birthDate, int clientType, String email, String lastName, String name, String password,
			String phoneNumber) {
		super();
		this.birthDate = birthDate;
		this.clientType = clientType;
		this.email = email;
		this.lastName = lastName;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	

	
	public Client(int idClient, String email, String lastName, String name, String password, String phoneNumber) {
		super();
		this.idClient = idClient;
		this.email = email;
		this.lastName = lastName;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}




	public Client(Date birthDate, String email, String lastName, String name, String password,
			String phoneNumber) {
		super();
		this.birthDate = birthDate;
	
		this.email = email;
		this.lastName = lastName;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdClient")
	private int idClient;

	@Column(name="BirthDate")
	private Date birthDate;

	@Column(name="ClientType")
	private int clientType;

	@Column(name="Email")
	private String email;

	@Column(name="LastName")
	private String lastName;

	@Column(name="Name")
	private String name;

	@Column(name="Password")
	private String password;

	@Column(name="PhoneNumber")
	private String phoneNumber;

	public Client() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public int getClientType() {
		return this.clientType;
	}

	public void setClientType(int clientType) {
		this.clientType = clientType;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}