package com.ladera.request.payload;

public class WingCreationRequest {
	
	private String wingCode;

	private String wingName;

	private int wingCapacity;

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
	

}
