package com.wjs.model;

import java.io.Serializable;

public class User implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String lastName;
	private String firstName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	

}
