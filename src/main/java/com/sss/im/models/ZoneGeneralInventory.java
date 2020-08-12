package com.sss.im.models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import org.hibernate.annotations.GenericGenerator;
import com.sss.im.models.compositekeys.ZoneInventoryID;


@Entity
@IdClass(ZoneInventoryID.class)
public class ZoneGeneralInventory {
	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	String sId;
	@Id
	String itemName;
	@Id
	String zoneName;
	int count;
	String description;
	String createdBy;
	Date created;
	String updatedBy;
	Date updated;
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	@Override
	public String toString() {
		return "ZoneGeneralInventory [sId=" + sId + ", itemName=" + itemName + ", zoneName=" + zoneName + ", count="
				+ count + ", description=" + description + ", createdBy=" + createdBy + ", created=" + created
				+ ", updatedBy=" + updatedBy + ", updated=" + updated + "]";
	}
	
	
}
