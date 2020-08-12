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
public class InventoryPurchase {

	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Id
	String purchaseId;
	String description;
	String vendorName;
	String invoiceNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date purchaseDate;
	String createdBy;
	Date created;
	String updatedBy;
	Date updated;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="purchaseId", referencedColumnName="purchaseId" )
	List<InventoryPurchaseItem> items;

	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public List<InventoryPurchaseItem> getItems() {
		return items;
	}

	public void setItems(List<InventoryPurchaseItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "InventoryPurchase [purchaseId=" + purchaseId + ", description=" + description + ", vendorName="
				+ vendorName + ", invoiceNumber=" + invoiceNumber + ", purchaseDate=" + purchaseDate + ", createdBy="
				+ createdBy + ", created=" + created + ", updatedBy=" + updatedBy + ", updated=" + updated + ", items="
				+ items + "]";
	}
	
	
}
