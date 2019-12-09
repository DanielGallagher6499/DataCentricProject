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
public class ProductController {
	
	DAO dao;
	ArrayList<Products> products;
	
	public ProductController() {
		super();
		try {
			dao = new DAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadProducts() {
		System.out.println("In loadproducts()");
		try {
			products = dao.loadProducts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(Products p) {
		try {
			dao.deleteProduct(p.getPid());
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public ArrayList<Products> getProducts() {
		return products;
	}
	
}
