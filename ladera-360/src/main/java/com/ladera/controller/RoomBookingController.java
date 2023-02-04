package com.ladera.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.acls.model.AlreadyExistsException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.custom.exception.SoltAlreadyBookedException;
import com.ladera.request.payload.RoomBookingRequest;
import com.ladera.service.RoomBookingService;

@RequestMapping("ladera/booking")
@RestController
public class RoomBookingController {

	@Autowired
	RoomBookingService roomBookingService;

	@RequestMapping(value = "/room", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = {
			RequestMethod.POST })
	public HttpStatus bookRoom(@RequestBody final RoomBookingRequest roomBookingRequest)
			throws SoltAlreadyBookedException {

		try {
			roomBookingService.bookRoom(roomBookingRequest);
		} catch (final AlreadyExistsException ex) {
			throw ex;
		}
		return HttpStatus.OK;

	}
	
	
	public HttpStatus getBookedEntries(@PathVariable String roomId, @PathVariable Date bookingDate ){

		try {
			
		} catch (final AlreadyExistsException ex) {
			throw ex;
		}
		return HttpStatus.OK;

	}

}
