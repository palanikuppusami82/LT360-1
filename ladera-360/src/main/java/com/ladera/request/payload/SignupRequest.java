package com.ladera.request.payload;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.ladera.helper.utils.Gender;
 
/**
* class  registration  request 
* @author Vigneshwaran k
*/
public class SignupRequest {
   
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String emailId;
    
    private List<String> role;
    
    @Override
	public String toString() {
		return "SignupRequest [emailId=" + emailId + ", role=" + role + ", firstName=" + firstName + ", lastName="
				+ lastName + ", empId=" + empId + ", mobileNumber=" + mobileNumber + ", gender=" + gender + "]";
	}

	@NotBlank
    @Size(min = 6, max = 40)
    private String password;
    
    private String firstName;
    
    private String lastName;
    
    @NotBlank
    private String empId;
    
    @NotBlank
    private String mobileNumber;
    
    @NotBlank
    private Gender gender;
  
    public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	} 

	public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<String> getRole() {
      return this.role;
    }
    
    public void setRole(List<String> role) {
      this.role = role;
    }

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
