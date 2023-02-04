package com.ladera.request.payload;

import java.util.Date;

import javax.validation.constraints.NotBlank;

/**
 * class for booking request
 * 
 * @author Vigneshwaran k
 */

public class RoomBookingRequest {

	@NotBlank
	private String roomId;
	@NotBlank
	private long empId;
	@NotBlank
	private String bookingEmailId;
	
	private String bookingDiscription;
	@NotBlank
	private Date bookingDate;
	@NotBlank
	private String startTime;
	@NotBlank
	private String endTime;
	
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getBookingEmailId() {
		return bookingEmailId;
	}
	public void setBookingEmailId(String bookingEmailId) {
		this.bookingEmailId = bookingEmailId;
	}
	public String getBookDiscription() {
		return bookingDiscription;
	}
	public void setBookDiscription(String bookDiscription) {
		this.bookingDiscription = bookDiscription;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
