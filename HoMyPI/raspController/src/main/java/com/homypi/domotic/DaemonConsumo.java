package com.homypi.domotic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.homypi.persistance.MongoDBSingleton;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class DaemonConsumo {
	
	
	public static void main(String[] args) {
		
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH); // Quoted "Z" to indicate UTC, no timezone offset
		df.setTimeZone(tz);
		String nowAsISO = df.format(new Date());		
		DateTimeFormatter parser = ISODateTimeFormat.dateTime();
		DateTime result;
		Date newResult;
		result = parser.parseDateTime(nowAsISO);
		newResult = result.toDate();
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		DB db = dbSingleton.getTestdb();
		DBCollection coll = db.getCollection("consumos"); 
		BasicDBObject doc = new BasicDBObject("valor", SerialRaspberryController.genericSerialRequest(SerialRaspberryController.GET_CONSUMO)).append("date", newResult);
//		BasicDBObject doc = new BasicDBObject("valor", 100).append("date", newResult );
		coll.insert(doc);
		dbSingleton.closeConection();
	}

}
