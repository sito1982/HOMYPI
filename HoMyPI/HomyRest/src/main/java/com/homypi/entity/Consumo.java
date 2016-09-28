package com.homypi.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Consumo")
public class Consumo {
	
	@Id
	private String id;
	
	public long consumo;
	public Date time;
	
	public long getConsumo() {
		return consumo;
	}
	public void setConsumo(long consumo) {
		this.consumo = consumo;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
