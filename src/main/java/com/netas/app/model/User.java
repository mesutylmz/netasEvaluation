package com.netas.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="USER")
@XmlRootElement
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userSequenceGen")
	@SequenceGenerator(name="userSequenceGen",sequenceName="USER_SEQUENCE")
	private Long 	id;
	
	@Column(name="NAME") // login
	private String 	name;
	
	@Column(name="PHONENUMBER")
	private String 	phoneNumber;
	
	@Column(name="EMAIL")
	private String  email;
	
	@Column(name="ROLE_ID")
	private int  role;
	
	@Column(name="CREATED_DATE")
	private Date 	createdDate;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date 	lastModifiedDate;
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
