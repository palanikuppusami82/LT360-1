package com.ladera.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ladera.request.payload.AssetData;

public interface AssetService {

	public void createAssest(AssetData request,MultipartFile[] files); 
	
	public AssetData getAssest(String name); 
	
	public List<AssetData> getAllAssest();
}
