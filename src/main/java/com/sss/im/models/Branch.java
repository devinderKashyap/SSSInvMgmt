package com.sss.im.models;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Branch {
	
	@Id
	String branchId;
	String name;
	String address;
	String inCharge;
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
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
		return "Branch [branchId=" + branchId + ", name=" + name + ", address=" + address + ", inCharge=" + inCharge
				+ "]";
	}

	
}
