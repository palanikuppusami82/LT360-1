package com.ladera.service;

import java.util.List;

import com.ladera.request.payload.RoomData;

public interface RoomService {

	public void createRoom(RoomData request); 
	
	public RoomData getRoom(String name); 
	
	public List<RoomData> getAllRooms();
}
