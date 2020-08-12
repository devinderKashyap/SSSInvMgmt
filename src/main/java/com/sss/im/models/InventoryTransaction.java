package com.sss.im.models;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class InventoryTransaction {
	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Id
	String transactionId;
	String transactionType;//inbound,outbound
	String assignedType;// personal,zone
	String zoneName;
	String personName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date transactionDate;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="transactionId", referencedColumnName="transactionId")
	List<InventoryTransactionItem> items;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getAssignedType() {
		return assignedType;
	}

	public void setAssignedType(String assignedType) {
		this.assignedType = assignedType;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public List<InventoryTransactionItem> getItems() {
		return items;
	}

	public void setItems(List<InventoryTransactionItem> items) {
		this.items = items;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "InventoryTransaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", assignedType=" + assignedType + ", zoneName=" + zoneName + ", personName=" + personName
				+ ", transactionDate=" + transactionDate + ", items=" + items + "]";
	}

}
