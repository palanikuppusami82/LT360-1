package com.ladera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ladera.model.Email;

@Repository
public interface EmailRepository  extends JpaRepository<Email, Long>{
	
	@Query("SELECT e FROM Email as e WHERE e.emailCode = :emailCode")
	public Email getEmailByCode(@Param("emailCode")String emailCode);


}
