package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User data")
public class User {
	private Integer id;
	
	@Size(min=2, message = "Name should be at least 2 characters long")
	private String name;
	
	@Past
	@ApiModelProperty(notes = "Birthday should be before current time")
	private Date birthDate;
	
	
	
	public User(Integer id, String name, Date birthdDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthdDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthdDate) {
		this.birthDate = birthdDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdDate=" + birthDate + "]";
	}
	
	
}
