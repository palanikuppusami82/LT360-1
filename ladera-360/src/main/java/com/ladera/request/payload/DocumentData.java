package com.ladera.request.payload;

import javax.validation.constraints.NotBlank;

/**
* class for create room request 
* @author Vigneshwaran k
*/
public class DocumentData {

	
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	@NotBlank
	private String fileName;
	@NotBlank
	private byte[] fileData;
	
	@NotBlank
	private String documentType;
	
	
	}
