package com.shops;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.shops.Store;


public class DAO {

	private DataSource mysqlDS;

	
	/* ======================================================================================================
	 * Constructor
	 * ====================================================================================================== */
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/shops";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	/* ======================================================================================================
	 * Load Stores Function
	 * ====================================================================================================== */
	public ArrayList<Store> loadStores() throws Exception {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from store";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);
		
		ArrayList<Store> stores = new ArrayList<Store>();

		// process result set
		while (myRs.next()) {
			Store s = new Store();
			s.setId(myRs.getInt("id"));
			s.setName(myRs.getString("name"));
			s.setFounded(myRs.getString("founded"));
			stores.add(s);
		}
		return stores;
	}
	
	/* ======================================================================================================
	 * Add store function
	 * ====================================================================================================== */
	public void addStore(Store store) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into store values (?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, store.getId());
		myStmt.setString(2, store.getName());
		myStmt.setString(3, store.getFounded());
		myStmt.execute();			
	}
	
	/* ======================================================================================================
	 * LOading products from products page
	 * ====================================================================================================== */
	public ArrayList<Products> loadProducts() throws Exception {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from product";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);
		
		ArrayList<Products> products = new ArrayList<Products>();

		// process result set
		while (myRs.next()) {
			Products p = new Products();
			p.setPid(myRs.getInt("pid"));
			p.setSid(myRs.getInt("sid"));
			p.setProdName(myRs.getString("prodName"));
			p.setPrice(myRs.getDouble("price"));
			

			products.add(p);
		}
		return products;
	}
	
	/* ======================================================================================================
	 * Delete products function
	 * ====================================================================================================== */
	public void deleteProduct (int id) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "delete from product where pid = ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, id);
		myStmt.execute();	
	}
	
	/* ======================================================================================================
	 * Delete store function
	 * ====================================================================================================== */
	public void deleteStore (int id) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "delete from store where id = ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, id);
		myStmt.execute();	
	}
	
	/* ======================================================================================================
	 * Load store products
	 * ====================================================================================================== */
	public ArrayList<StoreProduct> loadStoreProducts(int id) throws Exception {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select s.*,p.* from store as s left join product as p on p.sid=s.id where id=" + id;

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);
		
		ArrayList<StoreProduct> StoreProducts = new ArrayList<StoreProduct>();

		// process result set
		while (myRs.next()) {
			StoreProduct sp = new StoreProduct();
			sp.setSid(myRs.getInt("id"));
			sp.setStoreName(myRs.getString("name"));
			sp.setFounded(myRs.getString("founded"));
			sp.setPid(myRs.getInt("pid"));
			sp.setProductName(myRs.getString("prodName"));
			sp.setPrice(myRs.getDouble("price"));
			System.out.println(sp.storeName);
			StoreProducts.add(sp);
		}
		return StoreProducts;
	}
}

