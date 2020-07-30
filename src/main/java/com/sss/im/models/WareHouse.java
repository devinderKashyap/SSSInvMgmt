package com.sss.im.models;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class WareHouse {
	@Id
	String wId;
	String name;
	String address;
	String inCharge;
	public String getwId() {
		return wId;
	}
	public void setwId(String wId) {
		this.wId = wId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInCharge() {
		return inCharge;
	}
	public void setInCharge(String inCharge) {
		this.inCharge = inCharge;
	}
	@Override
	public String toString() {
		return "WareHouse [wId=" + wId + ", name=" + name + ", address=" + address + ", inCharge=" + inCharge + "]";
	}

	
}
