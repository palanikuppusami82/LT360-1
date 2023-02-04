package com.ladera.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "room")
@SequenceGenerator(name="room_seq", initialValue=1, allocationSize=100)
public class Room {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "room_seq")
	private Long id;
	
	@Column(name = "room_id")
	private String roomId;
	
	@Column(name = "name")
	public String name;

	@Column(name = "description")
	public String description;

	@Column(name = "size")
	public String roomType;
	
	@Column(name = "seat_capacity")
	public int seatCapacity;
	
	@Column(name = "additionalfacilities")
	public String additionalFacilities;
	
	public Room() {

	}

	public Room(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public String getAdditionalFacilities() {
		return additionalFacilities;
	}

	public void setAdditionalFacilities(String additionalFacilities) {
		this.additionalFacilities = additionalFacilities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
