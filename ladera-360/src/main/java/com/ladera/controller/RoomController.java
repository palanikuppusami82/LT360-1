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

import com.ladera.request.payload.RoomData;
import com.ladera.service.RoomService;

@RequestMapping("ladera/api/room/")
@RestController
public class RoomController {
	
	Logger logger = LoggerFactory.getLogger(RoomController.class);

	@Autowired
	RoomService roomService;
	
	@PostMapping("createroom")
	public ResponseEntity<?> createRooms(@Valid @RequestBody RoomData roomRequest) {
		logger.info("Room create request :: {}",roomRequest.toString());
		roomService.createRoom(roomRequest);		
		return null;
	}

	@GetMapping("getAllRooms")
	public List<RoomData> getAllRooms() {
		return roomService.getAllRooms();		
	}
}
