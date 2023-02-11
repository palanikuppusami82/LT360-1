package com.ladera.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ladera.model.Asset;
import com.ladera.model.Document;
import com.ladera.repository.AssestRepository;
import com.ladera.request.payload.AssetData;
import com.ladera.service.AssetService;

@Service
@Transactional
public class DefaultLtAssetService implements AssetService {
	
	
	Logger logger = LoggerFactory.getLogger(DefaultLtAssetService.class);
	

	@Autowired
	AssestRepository assestRepository;
	
	@Autowired
	DefaultDocumentService documentService;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public void createAssest(AssetData request,MultipartFile[] files) {
		Asset assest = new Asset();
		modelMapper.map(request, assest);
		assestRepository.save(assest);
		if(ArrayUtils.isNotEmpty(files)) {
			Arrays.stream(files).forEach(e->{
				try {
					Document doc = new Document();
					doc.setFileName(e.getName());
					doc.setFileData(e.getBytes());
					doc.setAsset(assest);
					documentService.createDocument(doc);
				}catch(Exception ex) {
					logger.error("Exception due to {},file name{}",ex.getMessage(),e.getName());	
				}
			});
		}
	}

	@Override
	public AssetData getAssest(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssetData> getAllAssest() {
		List<AssetData> reDatas = new ArrayList<>();
		List<Asset> roomModels = assestRepository.findAll();
		if(CollectionUtils.isNotEmpty(roomModels)) {
			roomModels.forEach(r->{
				AssetData data = new AssetData();
				modelMapper.map(r,data);
				reDatas.add(data);
			});
		}
		return reDatas;
	}

		
	

}
