package com.ladera.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ladera.helper.utils.EmployeeStatus;
import com.ladera.helper.utils.Gender;
import com.ladera.helper.utils.StringListConverter;

@Entity
@Table(name = "employees")
@SequenceGenerator(name = "employee_seq", initialValue = 1, allocationSize = 100)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	@Column(name = "id")
	private Long id;

	@Column(name = "emp_code")
	private String empId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "email_id", nullable = false, unique = true)
	private String emailId;

	@Column(name = "password")
	private String password;

	@Convert(converter = StringListConverter.class)
	@Column(name = "emp_role", length = 256)
	private List<String> roles;

	@Column(name = "active")
	private Boolean isActive;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private EmployeeStatus status;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;

	@Column(name = "creation_time")
	private Date creationTime;

	public Employee() {
		
	}

	public Employee(String empCode, String firstName, String lastName, String mobileNumber, String emailId,
			String password, List<String> roles, Boolean isActive, Gender gender) {
		super();
		this.empId = empCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.password = password;
		this.roles = roles;
		this.isActive = isActive;
		this.status = EmployeeStatus.PENDING;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empCode) {
		this.empId = empCode;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "Employee [empCode=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", emailId=" + emailId + "]";
	}

}
