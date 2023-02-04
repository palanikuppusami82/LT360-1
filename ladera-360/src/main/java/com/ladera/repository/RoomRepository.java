package com.ladera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladera.model.Room;

@Repository
public interface RoomRepository  extends JpaRepository<Room, String>{

}
