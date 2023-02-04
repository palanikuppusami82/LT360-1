package com.ladera.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class AssetType{

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "asset_type")
	private String assetType;

}
