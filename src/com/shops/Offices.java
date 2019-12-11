package com.shops;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class Offices {
	
	/* ======================================================================================================
	 * Variables
	 * ====================================================================================================== */
	int storeID;
	String location;
	
	/* ======================================================================================================
	 * Getters and Setters
	 * ====================================================================================================== */
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
