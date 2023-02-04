package com.ladera.service;

import org.springframework.security.acls.model.AlreadyExistsException;

import com.ladera.request.payload.RoomBookingRequest;

public interface RoomBookingService {

	public void bookRoom(RoomBookingRequest bookingRequest) throws AlreadyExistsException; 

	
}
