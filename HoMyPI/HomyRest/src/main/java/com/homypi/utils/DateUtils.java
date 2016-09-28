package com.homypi.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

public class DateUtils {
	
	public static Date getDateNowMongoISODateFormat(){
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH); // Quoted "Z" to indicate UTC, no timezone offset
		df.setTimeZone(tz);
		String nowAsISO = df.format(new Date());		
		org.joda.time.format.DateTimeFormatter parser = ISODateTimeFormat.dateTime();
		DateTime result;
		result = parser.parseDateTime(nowAsISO);
		return result.toDate();
	}
	
	public static Date formatingDate(String fecha){
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        try {

            Date date = formatter.parse(fecha);            
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
	}

}
