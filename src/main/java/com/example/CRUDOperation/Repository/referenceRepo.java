package com.example.CRUDOperation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUDOperation.Entity.referenceEnity;

@Repository
public interface referenceRepo extends JpaRepository<referenceEnity, Long>{
	boolean existsByReferemail(String email);
	referenceEnity findByReferemail(String email);
	List<referenceEnity> findByCustid(long id);
}
