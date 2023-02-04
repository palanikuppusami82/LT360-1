package com.ladera.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.ladera.model.Employee;
import com.ladera.model.data.EmployeeData;
import com.ladera.repository.UserRepository;
import com.ladera.service.EmployeeService;

@Service
@Transactional
public class DefaultLtEmpoyeeService implements EmployeeService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public String approveEmployee(String emailId, final EmployeeData employeeData) {
		Employee employeeToActivate = userRepository.findByEmailId(emailId);
		if (ObjectUtils.isEmpty(employeeToActivate)) {
			throw new UsernameNotFoundException("Employee Not found with given user name" + emailId);
		}
		employeeToActivate.setRoles(employeeData.getRoles());
		employeeToActivate.setIsActive(employeeData.getIsActive());
		userRepository.save(employeeToActivate);
		return null;
	}

	@Override
	public Collection<EmployeeData> getEmployeePendingForApproval() {
		Collection<Employee> employeeModelList = userRepository.findByIsActiveIsNull();
		List<EmployeeData> employeeDataList = new ArrayList<EmployeeData>();
		for (Employee employeeModel : employeeModelList) {
			EmployeeData employeeData = new EmployeeData();
			modelMapper.map(employeeModel, employeeData);
			employeeDataList.add(employeeData);
		}
		return employeeDataList;
	}

}
