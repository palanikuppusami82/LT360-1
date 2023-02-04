package com.ladera.model.data;

import java.io.Serializable;
import java.util.Map;

public class WingSlotEntriesData  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Map<String,String> seatNumber;

	private String wingCode;

	private String wingName;

	private int wingCapacity;
	
	private Map<String,String> unAssignedEmployeeMap;


	public Map<String,String> getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Map<String,String> seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getWingCode() {
		return wingCode;
	}

	public void setWingCode(String wingCode) {
		this.wingCode = wingCode;
	}

	public String getWingName() {
		return wingName;
	}

	public void setWingName(String wingName) {
		this.wingName = wingName;
	}

	public int getWingCapacity() {
		return wingCapacity;
	}

	public void setWingCapacity(int wingCapacity) {
		this.wingCapacity = wingCapacity;
	}

	public Map<String, String> getUnAssignedEmployeeMap() {
		return unAssignedEmployeeMap;
	}

	public void setUnAssignedEmployeeMap(Map<String, String> unAssignedEmployeeMap) {
		this.unAssignedEmployeeMap = unAssignedEmployeeMap;
	}



}
