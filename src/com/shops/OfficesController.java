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
public class OfficesController {
	
	MongoDAO mongo;
	ArrayList<Offices> offices;
	
	/* ======================================================================================================
	 * Default Controller
	 * ====================================================================================================== */
	public OfficesController() {
		super();
		try {
			mongo = new MongoDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* ======================================================================================================
	 * Load offices
	 * ====================================================================================================== */
	public ArrayList<Offices> loadOffices() {
		System.out.println("Loading offices....");
		try {
			offices = mongo.loadOffices();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return offices;
	}

	/* ======================================================================================================
	 * Add offices
	 * ====================================================================================================== */
	public String addOffice(Offices o) throws Exception {
		try {
			mongo.addOffice(o);
			return "index";
		} catch (SQLIntegrityConstraintViolationException e) {
			FacesMessage message = 
					new FacesMessage("Error: Can't communicate with DB");
					FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (CommunicationsException e) {
			FacesMessage message = 
					new FacesMessage("Error: Can't communicate with DB");
					FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}
	
	/* ======================================================================================================
	 * Return Array List
	 * ====================================================================================================== */
	public ArrayList<Offices> getOffices() {
		return offices;
	}
	

}//Main

