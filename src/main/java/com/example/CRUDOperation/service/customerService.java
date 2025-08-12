package com.example.CRUDOperation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUDOperation.DTO.customerDTO;
import com.example.CRUDOperation.DTO.customerWithIdDTO;
import com.example.CRUDOperation.Entity.customerEnity;
import com.example.CRUDOperation.Repository.customerRepo;

@Service
public class customerService {
	
	@Autowired
	private customerRepo repo;
	
	public String insertNewCustomerDetails(customerDTO cust) {
		try {
			boolean emailExists = repo.existsByEmail(cust.getEmail());
			
			if(emailExists) {
				return "Email already exists";
			}else {
				customerEnity newCustData = new customerEnity();
				newCustData.setCustname(cust.getCustname());
				newCustData.setEmail(cust.getEmail());
				newCustData.setPhonenumber(cust.getPhonenumber());
				newCustData.setPass(cust.getPass());
				repo.save(newCustData);
				
				return "Success";
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "Error while inserting";
		}
	}
	
	public String authenticatingCustomer(customerDTO cust) {
		boolean emailExists = repo.existsByEmail(cust.getEmail());
		
		if(emailExists) {
			customerEnity custEntity = repo.findByEmail(cust.getEmail());
			if(cust.getPass().equals(custEntity.getPass())) {
//				cust.setCustname(custEntity.getCustname());
//				cust.setPhonenumber(custEntity.getPhonenumber());
				return "Success";
			}else {
				return "Password is incorrect";
			}
		}else {
			return "Email-id is not registered";
		}
	}
	
	public customerWithIdDTO fetchValidCustomerDetails(String email) {
		customerEnity custEntity = repo.findByEmail(email);
		customerWithIdDTO cust = new customerWithIdDTO();
		cust.setId(custEntity.getId());
		cust.setCustname(custEntity.getCustname());
		cust.setPhonenumber(custEntity.getPhonenumber());
		cust.setEmail(custEntity.getEmail());
		cust.setPass(custEntity.getPass());
		return cust;
	}

}
