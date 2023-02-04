package com.ladera.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wingsseatentry")
public class WingSlotEntries {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seat_entry_seq")
	private long id;
	
	@Column(name = "seat_number")
	private String seatNumber;

	@Column(name = "lan_port")
	private String lanPort;

	@ManyToOne
	@JoinColumn(name = "slot_id", referencedColumnName = "wing_id")
	private Wings wings;

	@OneToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;
	
	@Column(name = "slot_status")
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getLanPort() {
		return lanPort;
	}

	public void setLanPort(String lanPort) {
		this.lanPort = lanPort;
	}

	public Wings getWings() {
		return wings;
	}

	public void setWings(Wings wings) {
		this.wings = wings;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
