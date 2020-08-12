package com.sss.im.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class InventoryDisposalItem {
	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Id
	String iId;
	String disposalId;
	String itemName;
	int count;
	String details;
	public String getIId() {
		return iId;
	}
	public void setIId(String iId) {
		this.iId = iId;
	}
	public String getDisposalId() {
		return disposalId;
	}
	public void setDisposalId(String disposalId) {
		this.disposalId = disposalId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "InventoryDisposalItem [iId=" + iId + ", disposalId=" + disposalId + ", itemName=" + itemName
				+ ", count=" + count + ", details=" + details + "]";
	}
	
	
}
