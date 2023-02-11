package com.ladera.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladera.model.Document;
import com.ladera.repository.DocumentRepository;
import com.ladera.request.payload.DocumentData;
import com.ladera.service.DocumentService;

@Service
public class DefaultDocumentService  implements DocumentService{

	@Autowired
	DocumentRepository documentRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public void createDocument(Document doc) {
		documentRepository.save(doc);
		
	}
	@Override
	public DocumentData getDocuments(Long id) {
		 Optional<Document> doc = documentRepository.findById(id);
		 if(doc.isPresent()) {
			 DocumentData data = new DocumentData();
			 modelMapper.map(doc, data);
			 return data;
		 }
		return null;
	}

	
	@Override
	public void deleteDocument(Long id) {
		 documentRepository.deleteById(id);
	}
		

	
	@Override
	public List<DocumentData> getAllDocument() {
		// TODO Auto-generated method stub
		return null;
	}

}
