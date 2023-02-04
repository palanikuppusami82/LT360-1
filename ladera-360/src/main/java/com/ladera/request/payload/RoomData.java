package com.ladera.request.payload;

import javax.validation.constraints.NotBlank;

/**
 * class for create room request
 * 
 * @author Vigneshwaran k
 */
public class RoomData {

	@NotBlank
	private String roomId;

	@NotBlank
	private String name;

	@NotBlank
	private String size;
	@NotBlank

	public String description;

	@NotBlank
	public int seatCapacity;

	@NotBlank
	private String roomType;

	public String additionalFacilities;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public String getRoomName() {
		return name;
	}

	public void setRoomName(String name) {
		this.name = name;
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

}
