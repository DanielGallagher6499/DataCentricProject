package com.shops;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Store {
	
	/* ======================================================================================================
	 * Variables
	 * ====================================================================================================== */
	int id;
	String name;
	String founded;
	
	/* ======================================================================================================
	 * Getters and setters
	 * ====================================================================================================== */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFounded() {
		return founded;
	}
	public void setFounded(String founded) {
		this.founded = founded;
	}

}
