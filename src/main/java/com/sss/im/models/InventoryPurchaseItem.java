package com.sss.im.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class InventoryPurchaseItem {
	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Id
	String ipId;
	String purchaseId;
	String itemName;
	int count;
	String details;
	public String getIpId() {
		return ipId;
	}
	public void setIpId(String ipId) {
		this.ipId = ipId;
	}
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
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
		return "InventoryPurchaseItem [ipId=" + ipId + ", purchaseId=" + purchaseId + ", itemName=" + itemName
				+ ", count=" + count + ", details=" + details + "]";
	}
	
	
}
