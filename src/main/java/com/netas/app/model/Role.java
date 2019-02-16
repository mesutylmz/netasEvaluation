package com.netas.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="ROLE")
@XmlRootElement
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="roleSequenceGen")
	@SequenceGenerator(name="roleSequenceGen",sequenceName="ROLE_SEQUENCE")
	private Long 	id;
	
	@Column(name="NAME")
	private String 	name;

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
}
