package com.ladera.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ladera.model.RoomBookingEntries;

@Repository
public interface RoomBookingRepository extends JpaRepository<RoomBookingEntries, Integer> {
	
	@Query(value = "SELECT * FROM roombookingentries re WHERE re.roomid = :roomId AND re.bookingdate = :bookingDate", nativeQuery = true)
	Collection<RoomBookingEntries> findByBookingDateAndRoomId(String roomId, Date bookingDate);
	
}
