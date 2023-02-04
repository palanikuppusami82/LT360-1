package com.ladera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladera.model.Wings;

@Repository
public interface WingsRepository extends JpaRepository<Wings, Long> {

	public Wings findByWingCode(String wingCode);
}
