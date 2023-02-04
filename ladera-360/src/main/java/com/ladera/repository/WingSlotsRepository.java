package com.ladera.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ladera.model.WingSlotEntries;

@Repository
public interface WingSlotsRepository extends JpaRepository<WingSlotEntries, Long>{

	@Query("SELECT e FROM WingSlotEntries as e JOIN e.wings as ws WHERE ws.wingCode = :wingCode")
	public Collection<WingSlotEntries> getWingById(@Param("wingCode")String wingCode);

}
