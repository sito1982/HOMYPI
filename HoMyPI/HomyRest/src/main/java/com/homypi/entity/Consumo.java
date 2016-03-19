package com.homypi.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement()  
public class Consumo {
	
	
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
	
	
	

}
