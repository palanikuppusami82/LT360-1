package com.ladera.service;

import java.util.Collection;

import com.ladera.model.data.EmployeeData;

public interface EmployeeService {
	
	public String approveEmployee(String emailId, final EmployeeData employeeData);
 
	public Collection<EmployeeData> getEmployeePendingForApproval();
	
}
