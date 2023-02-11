package com.ladera.request.payload;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

/**
* class for create room request 
* @author Vigneshwaran k
*/
public class AssetData {

	@Override
	public String toString() {
		return "AssestData [code=" + code + ", warrantyPeriod=" + warrantyPeriod + ", serialNumber=" + serialNumber
				+ ", description=" + description + ", assestType=" + assestType + ", brand=" + brand
				+ ", warrantyEndDate=" + warrantyEndDate + ", assignedOn=" + assignedOn + "]";
	}

	@NotBlank
	private String code;
	@NotBlank
	private String warrantyPeriod;
	@NotBlank
	private String serialNumber;
	@NotBlank
	private String description;
	@NotBlank
	private String assestType;
	
	@NotBlank
	private String brand;
	
	private Date warrantyEndDate;
	
	private Date assignedOn;
	
	List<DocumentData> documentList;

	public List<DocumentData> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<DocumentData> documentList) {
		this.documentList = documentList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAssestType() {
		return assestType;
	}

	public void setAssestType(String assestType) {
		this.assestType = assestType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getWarrantyEndDate() {
		return warrantyEndDate;
	}

	public void setWarrantyEndDate(Date warrantyEndDate) {
		this.warrantyEndDate = warrantyEndDate;
	}

	public Date getAssignedOn() {
		return assignedOn;
	}

	public void setAssignedOn(Date assignedOn) {
		this.assignedOn = assignedOn;
	}
	

	}
