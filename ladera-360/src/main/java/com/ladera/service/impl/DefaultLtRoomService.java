package com.ladera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ladera.model.Room;
import com.ladera.repository.RoomRepository;
import com.ladera.request.payload.RoomData;
import com.ladera.service.RoomService;

@Service
@Transactional
public class DefaultLtRoomService implements RoomService {

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public void createRoom(RoomData request) {
		Room roomModel = new Room();
		modelMapper.map(request, roomModel);
		roomRepository.save(roomModel);
	}

	@Override
	public RoomData getRoom(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomData> getAllRooms() {
		// TODO Auto-generated method stub
		List<RoomData> reDatas = new ArrayList<>();
		List<Room> roomModels = roomRepository.findAll();
		if(CollectionUtils.isNotEmpty(roomModels)) {
			roomModels.forEach(r->{
				RoomData data = new RoomData();
				modelMapper.map(r,data);
				reDatas.add(data);
			});
		}
		return reDatas;
	}
	
	

}
