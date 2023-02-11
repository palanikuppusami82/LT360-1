package com.ladera.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ladera.request.payload.AssetData;
import com.ladera.service.AssetService;

@RequestMapping("ladera/api/asset/")
@RestController
public class AssetController {
	Logger logger = LoggerFactory.getLogger(AssetController.class);
	
	@Autowired
	AssetService assestService;
	
	@PostMapping("createAsset")
	public ResponseEntity<?> createAsset(@Valid @RequestBody AssetData assestData,final MultipartFile[] files) {
		logger.info("Create Asset data {}",assestData.toString());
		assestService.createAssest(assestData,files);		
		return null;
	}

	@GetMapping("getAllAsset")
	public List<AssetData> getAllAssests() {
		return assestService.getAllAssest();		
	}
}
