package com.homypi.services;

import java.io.InputStream;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.homypi.domotic.SerialRaspberryController;
import com.homypi.entity.Consumo;
import com.homypi.persistance.MongoDBSingleton;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

@Path("/message")
public class HomyPiRestService {

	@GET
	@Path("/verify")
	public String verifyRESTService(InputStream incomingData) {
		System.out.println("RESTful Service 'MessageService' is running ==> ping");
		return "received ping on " + new Date().toString();
	}

	@POST
	@Path("/consumo")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addConsumo(Consumo concumo) {

		System.out.println(concumo.getConsumo());
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		DB db = dbSingleton.getTestdb();
		DBCollection coll = db.getCollection("Consumo"); 
		BasicDBObject doc = new BasicDBObject("concumo", concumo.getConsumo()).append("time", concumo.getTime());
		coll.insert(doc);
		
		return "looool";
	}
	
	@GET
	@Path("/verify")
	public String getSerial(){
		
		return SerialRaspberryController.getSalidaSerial(); 
		
	}

}
