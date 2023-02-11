package com.ladera.service;

import java.util.List;

import com.ladera.model.Document;
import com.ladera.request.payload.DocumentData;

public interface DocumentService {

	public void createDocument(Document doc); 
	
	public DocumentData getDocuments(Long id); 
	
	public List<DocumentData> getAllDocument();
	
	public void deleteDocument(Long id);
}
