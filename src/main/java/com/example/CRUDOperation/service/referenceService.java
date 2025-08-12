package com.example.CRUDOperation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUDOperation.DTO.referenceDTO;
import com.example.CRUDOperation.Entity.customerEnity;
import com.example.CRUDOperation.Entity.referenceEnity;
import com.example.CRUDOperation.Repository.referenceRepo;
import com.example.CRUDOperation.Repository.customerRepo;

@Service
public class referenceService {
	
	@Autowired
	private referenceRepo repo;
	
	@Autowired
	private customerRepo customerRepo;
	
	public String insertNewReferenceDetails(referenceDTO cust) {
		try {
			boolean emailExists = repo.existsByReferemail(cust.getReferemail());
			
			if(emailExists) {
				return "Email already exists";
			}else {
				referenceEnity newRefData = new referenceEnity();
				newRefData.setCustid(cust.getCustid());
				newRefData.setReferemail(cust.getReferemail());
				newRefData.setAddress(cust.getAddress());
				newRefData.setRefername(cust.getRefername());
				newRefData.setReferphonenumber(cust.getReferphonenumber());
				newRefData.setRelation(cust.getRelation());
				repo.save(newRefData);
				
				return "Success";
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "Error while inserting";
		}
	}
	
	
	public List<referenceDTO> fetchValidReferenceDetails(String email) {
		customerEnity data = customerRepo.findByEmail(email);
		
		List<referenceEnity> fetchedDetails = repo.findByCustid(data.getId());
		List<referenceDTO> dtoList = new ArrayList<>();
		
		for (referenceEnity datas : fetchedDetails) {
			referenceDTO cust = new referenceDTO();
	        cust.setRefername(datas.getRefername());
	        cust.setAddress(datas.getAddress());
	        cust.setCustid(datas.getCustid());
	        cust.setReferemail(datas.getReferemail());
	        cust.setReferphonenumber(datas.getReferphonenumber());
	        cust.setRelation(datas.getRelation());
	        dtoList.add(cust);
	    }
		
		return dtoList;
	}

}
