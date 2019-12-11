 package com.shops;

import java.util.ArrayList;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDAO {
	
	String mongoDB = "storeHeadOfficeDB";
	String mongoCollection = "storeHeadOffice";
	
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;
	
	
	/* ======================================================================================================
	 * Constructor
	 * ====================================================================================================== */
	public MongoDAO() throws Exception {
		mongoClient = new MongoClient();
		database = mongoClient.getDatabase(mongoDB);
		collection = database.getCollection(mongoCollection);
	}
	
	/* ======================================================================================================
	 * Load offices function 
	 * ====================================================================================================== */
	public ArrayList<Offices> loadOffices() throws Exception {
		ArrayList<Offices> offices = new ArrayList<Offices>();
		FindIterable<Document> docOffice = collection.find();
		
		for(Document docs:docOffice) {
			Offices o = new Offices();
			o.setStoreID((int) (docs.getInteger("_id")));
			o.setLocation((String) (docs.get("location")));
		
		offices.add(o);
	}
	//mongoClient.close();
	return offices;
}


	/* ======================================================================================================
	 * Add Office Function
	 * ====================================================================================================== */
	public void addOffice(Offices office) throws Exception {
		Document d = new Document();
		d.append("_id",office.getStoreID());
		d.append("location",office.getLocation());
		collection.insertOne(d);
	}
}
