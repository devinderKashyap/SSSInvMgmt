package com.sss.im.models;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class InventoryItem {
	@Id
	String itemId;
	String name;
	String description;
	int quantity;
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "InventoryItem [itemId=" + itemId + ", name=" + name + ", description=" + description + ", quantity="
				+ quantity + "]";
	}
	
	

}
