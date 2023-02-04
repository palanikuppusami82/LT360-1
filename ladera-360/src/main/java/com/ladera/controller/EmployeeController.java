package com.ladera.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.model.data.EmployeeData;
import com.ladera.service.EmployeeService;

@RequestMapping("ladera/api/employee")
@RestController
public class EmployeeController {

	// private static final Logger LOG = Logger.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getpending/user")
	public Collection<EmployeeData> getAllUserPendingForApproval() {
		Collection<EmployeeData> employeeCollection = employeeService.getEmployeePendingForApproval();
		return employeeCollection;
	}

	@RequestMapping(value = "/approve/user/{emailId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = {
	        RequestMethod.PUT})	
	public HttpStatus approveEmployeeForLogin(@PathVariable String emailId,
			@RequestBody final EmployeeData employeeData) {
		if(ObjectUtils.isEmpty(employeeData)) {
			
		}
		employeeService.approveEmployee(emailId,employeeData);
		return HttpStatus.OK;

	}

}
