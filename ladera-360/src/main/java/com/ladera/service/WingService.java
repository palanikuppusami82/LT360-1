package com.ladera.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ladera.model.data.WingSlotEntriesData;
import com.ladera.request.payload.WingCreationRequest;

public interface WingService {

	public WingSlotEntriesData getWingSlotsById(String wingCode);
	
	public  ResponseEntity<?> createWingForRequest(WingCreationRequest creationRequest);
	
	public List<WingSlotEntriesData> getAllWings();
}
