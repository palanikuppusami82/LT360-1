package com.ladera.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ladera.model.Employee;


@Repository
public interface UserRepository extends JpaRepository<Employee, Long>{

	public Employee findByEmailId(String emailId);
	
	@Query(value = "SELECT * FROM employees e WHERE e.active IS NULL ", nativeQuery = true)
	public Collection<Employee> findByIsActiveIsNull();
	
	
	@Query(value = "SELECT * FROM employees e WHERE  e.id IS NOT NULL AND e.id NOT IN (SELECT ws.employee_id FROM wingsseatentry ws where ws.employee_id IS NOT NULL) ", nativeQuery = true)
	public Collection<Employee> findUsersWithNoSeatAllocated();
	
	
	public Employee findByEmpId(String empId);
	
}
