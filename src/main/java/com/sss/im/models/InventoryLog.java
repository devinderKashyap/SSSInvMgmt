package com.sss.im.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class InventoryLog {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	String logID;
	Date date;
	String type;
	String toLoc;
	String fromLoc;
	int quantity;
	public String getLogID() {
		return logID;
	}
	public void setLogID(String logID) {
		this.logID = logID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getToLoc() {
		return toLoc;
	}
	public void setToLoc(String toLoc) {
		this.toLoc = toLoc;
	}
	public String getFromLoc() {
		return fromLoc;
	}
	public void setFromLoc(String fromLoc) {
		this.fromLoc = fromLoc;
	}
	@Override
	public String toString() {
		return "InventoryLog [logID=" + logID + ", date=" + date + ", type=" + type + ", toLoc=" + toLoc + ", fromLoc="
				+ fromLoc + ", quantity=" + quantity + "]";
	}
	
	
	
}
