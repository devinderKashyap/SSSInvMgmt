package com.sss.im.models.compositekeys;

import java.io.Serializable;

public class ZoneInventoryID implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String itemName;
	String zoneName;
	
	public ZoneInventoryID() {}

	public ZoneInventoryID(String itemName, String zoneName) {
		super();
		this.itemName = itemName;
		this.zoneName = zoneName;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((zoneName == null) ? 0 : zoneName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZoneInventoryID other = (ZoneInventoryID) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (zoneName == null) {
			if (other.zoneName != null)
				return false;
		} else if (!zoneName.equals(other.zoneName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ZoneInventoryID [itemName=" + itemName + ", zoneName=" + zoneName + "]";
	}
	
	
	
	

}
