package com.ladera.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wings")
public class Wings {

	@Id
	@Column(name = "wing_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "wings_seq")
    private long id;

	@Column(name = "wing_code",unique = true)
	private String wingCode;

	@Column(name = "wing_name")
	private String wingName;

	@Column(name = "wing_capacity")
	private int wingCapacity;
	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWingCode() {
		return wingCode;
	}

	public void setWingCode(String wingCode) {
		this.wingCode = wingCode;
	}

	public String getWingName() {
		return wingName;
	}

	public void setWingName(String wingName) {
		this.wingName = wingName;
	}

	public int getWingCapacity() {
		return wingCapacity;
	}

	public void setWingCapacity(int wingCapacity) {
		this.wingCapacity = wingCapacity;
	}

}
