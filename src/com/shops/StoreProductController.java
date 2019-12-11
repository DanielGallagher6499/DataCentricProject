package com.shops;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

@ManagedBean
@SessionScoped

public class StoreProductController {
	
	DAO dao;
	ArrayList<StoreProduct> storeProducts;
	
	public StoreProductController() {
		super();
		try {
			dao = new DAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/* ======================================================================================================
	 * Load Store Products
	 * ====================================================================================================== */
	public String loadStoreProducts(int sp) {
		System.out.println("In load products()");
		try {
			storeProducts = dao.loadStoreProducts(sp);
			return "storeProduct";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/* ======================================================================================================
	 * Return Array List
	 * ====================================================================================================== */
	public ArrayList<StoreProduct> getStoreProducts(){
		return storeProducts;
	}

}
