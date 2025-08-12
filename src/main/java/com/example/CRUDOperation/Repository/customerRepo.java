package com.example.CRUDOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUDOperation.Entity.customerEnity;

@Repository
public interface customerRepo extends JpaRepository<customerEnity, Long>{
	boolean existsByEmail(String email);
	customerEnity findByEmail(String email);
}
