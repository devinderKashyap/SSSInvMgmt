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
public class InventoryDisposal {
	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Id
	String disposalId;
	String description;
	String vendorName;
	String type;// destroy,sold
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date disposalDate;
	
	String createdBy;
	Date created;
	String updatedBy;
	Date updated;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="disposalId", referencedColumnName="disposalId")
	List<InventoryDisposalItem> items;

	public String getDisposalId() {
		return disposalId;
	}

	public void setDisposalId(String disposalId) {
		this.disposalId = disposalId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDisposalDate() {
		return disposalDate;
	}

	public void setDisposalDate(Date disposalDate) {
		this.disposalDate = disposalDate;
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

	public List<InventoryDisposalItem> getItems() {
		return items;
	}

	public void setItems(List<InventoryDisposalItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "InventoryDisposal [disposalId=" + disposalId + ", description=" + description + ", vendorName="
				+ vendorName + ", type=" + type + ", disposalDate=" + disposalDate + ", createdBy=" + createdBy
				+ ", created=" + created + ", updatedBy=" + updatedBy + ", updated=" + updated + ", items=" + items
				+ "]";
	}
	
	
}
