package com.policy.policy.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "policy")
public class Policy {
	
	@Id
	private String numberPolicy;
	
	private String startTermDate;
	
	private String endTermDate;
	
	private String vehiclePlate;
	
	private String valuePolicy;
	
	
	@Transient
	private long lateDays;
	@Transient
	private long remainingDays;
	@Transient
	private boolean expired;
	
	public String getNumberPolicy() {
		return numberPolicy;
	}
	
	public void setNumberPolicy(String numberPolicy) {
		this.numberPolicy = numberPolicy;
	}
	
	public String getStartTermDate() {
		return startTermDate;
	}
	
	public void setStartTermDate(String startTermDate) {
		this.startTermDate = startTermDate;
	}
	
	public String getEndTermDate() {
		return endTermDate;
	}
	
	public void setEndTermDate(String endTermDate) {
		this.endTermDate = endTermDate;
	}
	
	public String getVehiclePlate() {
		return vehiclePlate;
	}
	
	public void setVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}
	
	public String getValuePolicy() {
		return valuePolicy;
	}
	
	public void setValuePolicy(String valuePolicy) {
		this.valuePolicy = valuePolicy;
	}
	
	public long getLateDays() {
		return lateDays;
	}
	
	public void setLateDays(long lateDays) {
		this.lateDays = lateDays;
	}
	
	public long getRemainingDays() {
		this.getDays();
		return remainingDays;
	}
	
	public void setRemainingDays(long remainingDays) {
		this.remainingDays = remainingDays;
	}
	
	public boolean isExpired() {
		return expired;
	}
	
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	
	
	public void getDays() {
		
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date startTermDate = Calendar.getInstance().getTime();
			Date endTermDate = formatter.parse(this.endTermDate);
			
			if(startTermDate.compareTo(endTermDate) < 0) {
				this.remainingDays = 1 + (endTermDate.getTime() - startTermDate.getTime()) / (24 * 60 * 60 * 1000);
			} else {
				this.lateDays = 1 + (startTermDate.getTime() - endTermDate.getTime()) / (24 * 60 * 60 * 1000);
				this.expired = true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
	}


	
}
