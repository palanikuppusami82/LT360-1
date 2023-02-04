package com.ladera.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.model.data.WingSlotEntriesData;
import com.ladera.request.payload.WingCreationRequest;
import com.ladera.service.WingService;

@RequestMapping("ladera/api/wings/")
@RestController
public class WingsController {

	Logger logger = LoggerFactory.getLogger(WingsController.class);

	@Autowired
	WingService wingService;

	@PostMapping("create")
	public ResponseEntity<?> createWing(@RequestBody WingCreationRequest creationRequest) {
		logger.info("request for wing creation : {}", creationRequest);
		return wingService.createWingForRequest(creationRequest);

	}

	@GetMapping("getwingslot/{wingCode}")
	public WingSlotEntriesData getWingSoltsByCode(@PathVariable String wingCode) {
		logger.info("Fetching Wing Solts ByCode : {}", wingCode);
		return wingService.getWingSlotsById(wingCode);
	}

}
