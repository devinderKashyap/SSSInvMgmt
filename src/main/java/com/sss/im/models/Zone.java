package com.sss.im.models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Zone {
	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	String zId;
	@Id
	String zoneName;
	String description;
	Date updated;
	String updatedBy;
//	String zonetype;
	public String getzId() {
		return zId;
	}
	public void setzId(String zId) {
		this.zId = zId;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
		description = desc;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Override
	public String toString() {
		return "Zone [zId=" + zId + ", zoneName=" + zoneName + ", description=" + description + ", updated=" + updated
				+ ", updatedBy=" + updatedBy + "]";
	}
	
	
	
}
