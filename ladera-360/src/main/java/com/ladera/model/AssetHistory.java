package com.ladera.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class AssetHistory {

	@Id
	@Column(name = "id")
	private Long id;

	@OneToMany
	@JoinColumn(name = "asset_id", referencedColumnName = "id")
	private Assest asset;

	@OneToMany
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Assest getAsset() {
		return asset;
	}

	public void setAsset(Assest asset) {
		this.asset = asset;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
