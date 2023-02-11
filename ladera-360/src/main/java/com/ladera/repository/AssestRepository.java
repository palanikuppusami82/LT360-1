package com.ladera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladera.model.Asset;

@Repository
public interface AssestRepository  extends JpaRepository<Asset, Long>{

}
