package com.sss.im.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ImUser {
	
	@Id
	String userName;
	String firstName;
	String lastName;
	String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ImUser [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + "]";
	}
	

}
