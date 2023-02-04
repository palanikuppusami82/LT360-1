package com.ladera.service.impl;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.AlreadyExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ladera.model.RoomBookingEntries;
import com.ladera.repository.RoomBookingRepository;
import com.ladera.request.payload.RoomBookingRequest;
import com.ladera.service.RoomBookingService;

@Service
@Transactional
public class DefaultLtRoomBookingService implements RoomBookingService {

	@Autowired
	RoomBookingRepository roomBookingRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	synchronized public void bookRoom(RoomBookingRequest bookingRequest) throws AlreadyExistsException {
		if (StringUtils.isNotEmpty(bookingRequest.getRoomId()) && Objects.nonNull(bookingRequest.getBookingDate())) {
			if (hasConflictTimePeriod(bookingRequest)) {
				throw new AlreadyExistsException(
						"Slot already booked on selected time line please choose different time slot :Start Time"
								+ bookingRequest.getStartTime() + "and :End Time" + bookingRequest.getEndTime());
			} else {
				RoomBookingEntries entry = new RoomBookingEntries();
				modelMapper.map(bookingRequest, entry);
				roomBookingRepository.save(entry);
				
			}
		}
	}

	private boolean hasConflictTimePeriod(RoomBookingRequest bookingRequest) {
		Collection<RoomBookingEntries> bookingEntires = roomBookingRepository
				.findByBookingDateAndRoomId(bookingRequest.getRoomId(), bookingRequest.getBookingDate());
		for (RoomBookingEntries entry : bookingEntires) {
			if (StringUtils.isNotEmpty(bookingRequest.getStartTime())
					&& StringUtils.isNotEmpty(bookingRequest.getEndTime())) {

				LocalTime currentBookingStartTime = LocalTime.parse(bookingRequest.getStartTime());
				LocalTime currentBookingEndTime = LocalTime.parse(bookingRequest.getEndTime());
				
				if( currentBookingStartTime.isBefore( LocalTime.parse(entry.getEndTime()) )  && ( currentBookingEndTime.isAfter( LocalTime.parse(entry.getStartTime()) ) )) {
					return true;
				}
			}
		}
		return false;

	}
}
