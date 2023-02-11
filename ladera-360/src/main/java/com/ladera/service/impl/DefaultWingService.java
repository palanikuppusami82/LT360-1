package com.ladera.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ladera.model.Employee;
import com.ladera.model.Room;
import com.ladera.model.WingSlotEntries;
import com.ladera.model.Wings;
import com.ladera.model.data.WingSlotEntriesData;
import com.ladera.repository.UserRepository;
import com.ladera.repository.WingSlotsRepository;
import com.ladera.repository.WingsRepository;
import com.ladera.request.payload.RoomData;
import com.ladera.request.payload.WingCreationRequest;
import com.ladera.service.WingService;

@Service
@Transactional
public class DefaultWingService implements WingService {

	@Autowired
	WingSlotsRepository wingSlotsRepository;

	@Autowired
	WingsRepository wingsRepository;

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public WingSlotEntriesData getWingSlotsById(String wingCode) {

		WingSlotEntriesData slotData = new WingSlotEntriesData();
		Map<String, String> slotIdAndStatusMap = new HashedMap<>();
		Collection<WingSlotEntries> wingSlotList = wingSlotsRepository.getWingById(wingCode);
		Collection<Employee> employeeWithOutSeat  = userRepository.findUsersWithNoSeatAllocated();
		Map<String, String> employeeWithOutSeatMap =  new HashedMap<>();
	    CollectionUtils.emptyIfNull(employeeWithOutSeat).forEach(e-> employeeWithOutSeatMap.put(e.getEmpId(), e.getEmailId()));
	    int availSize = 0;
		if (CollectionUtils.isNotEmpty(wingSlotList)) {
			for (WingSlotEntries slot : wingSlotList) {
				if (StringUtils.isEmpty(slotData.getWingCode())) {
					slotData.setWingCapacity(slot.getWings().getWingCapacity());
					slotData.setWingName(slot.getWings().getWingName());
					slotData.setWingCode(slot.getWings().getWingCode());
				}
				slotIdAndStatusMap.put(slot.getSeatNumber(), slot.getStatus());
				if(!StringUtils.equals("available", slot.getStatus())) {
					availSize++;	
				}
				
			}
			slotData.setAvailableCapacity(availSize);
			slotData.setSeatNumber(slotIdAndStatusMap);
			
			slotData.setUnAssignedEmployeeMap(employeeWithOutSeatMap);
			return slotData;
		}
		return null;
	}

	@Override
	public ResponseEntity<?> createWingForRequest(WingCreationRequest creationRequest) {

		try {
			Wings wing = new Wings();
			modelMapper.map(creationRequest, wing);
			wingsRepository.save(wing);
			Wings wingModel = wingsRepository.findByWingCode(creationRequest.getWingCode());
			String wingnumberCode = wingModel.getWingCode().replaceAll("[^0-9]", "");
			String prefix = "LT";
			for (int i = 1; i <= wingModel.getWingCapacity(); i++) {
				WingSlotEntries slotEntries = new WingSlotEntries();
				slotEntries.setSeatNumber(prefix + "-" + wingnumberCode + "-" + i);
				slotEntries.setStatus("available");
				slotEntries.setWings(wingModel);
				wingSlotsRepository.save(slotEntries);
			}
		} catch (Exception e) {
			// log.info(e.getMessage())
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Unable to create wing");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Wing Created Successfully");

	}

	@Override
	public List<WingSlotEntriesData> getAllWings() {
		List<WingSlotEntriesData> slotData = new ArrayList<WingSlotEntriesData>();
		Collection<Wings> wingsList = wingsRepository.findAll();
		if (CollectionUtils.isNotEmpty(wingsList)) {
			for (Wings slot : wingsList) {
				slotData.add(getWingSlotsById(slot.getWingCode()));
			}
			
		}
		return slotData;
	}

}
