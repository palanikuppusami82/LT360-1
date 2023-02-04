package com.ladera.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roombookingentries")
public class RoomBookingEntries {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name = "roomentrynumber", updatable = false)
	private int roomEntryNumber;
	
	@Column(name = "roomid")
	private String roomId;
	
	@Column(name = "empid")
	private long empId;

	@Column(name = "bookingemailid")
	private String bookingEmailId;

	@Column(name = "bookdiscription")
	private String bookDiscription;

	@Column(name = "bookingdate")
	private Date bookingDate;

	@Column(name = "starttime")
	private String startTime;

	@Column(name = "endtime")
	private String endTime;

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
		return bookDiscription;
	}

	public void setBookDiscription(String bookDiscription) {
		this.bookDiscription = bookDiscription;
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

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

}
