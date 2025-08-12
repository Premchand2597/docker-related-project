package com.example.CRUDOperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CRUDOperation.DTO.customerDTO;
import com.example.CRUDOperation.DTO.customerWithIdDTO;
import com.example.CRUDOperation.DTO.referenceDTO;
import com.example.CRUDOperation.service.customerService;
import com.example.CRUDOperation.service.referenceService;


@Controller
public class MainController {
	
	@Autowired
	private customerService service;
	
	@Autowired
	private referenceService referenceService;
	
	@GetMapping("/")
	public String openLoginPage(@RequestParam(required = false) String errorStatus, Model model) {
		model.addAttribute("errorStatus", errorStatus);
		return "Login";
	}
	
	@PostMapping("/saveNewCustomer")
	public String insertNewCustomer(@ModelAttribute customerDTO customer, Model model){
		String status = service.insertNewCustomerDetails(customer);
		if("Success".equals(status)) {
			return "redirect:/";
		}
		return "redirect:/?errorStatus="+status;
	}

	@PostMapping("/logInCustomer")
	public String loggedInCustomer(@ModelAttribute customerDTO customer, Model model){
		String status = service.authenticatingCustomer(customer);
		if("Success".equals(status)) {
			return "redirect:/welcome/"+customer.getEmail();
		}
		return "redirect:/?errorStatus="+status;
	}

	@GetMapping("/welcome/{email}")
	public String openWelcomePage(@PathVariable String email, @RequestParam(required = false) String errorStatus, Model model) {
		customerWithIdDTO validCustomerDetails = service.fetchValidCustomerDetails(email);
		List<referenceDTO> validReferenceDetails = referenceService.fetchValidReferenceDetails(email);
		//System.out.println(validReferenceDetails);
		model.addAttribute("errorStatus", errorStatus);
		model.addAttribute("validReferenceDetails", validReferenceDetails);
		model.addAttribute("validCustomerDetails", validCustomerDetails);
		return "Welcome";
	}
	
	@PostMapping("/saveNewReference")
	public String insertNewReference(@ModelAttribute referenceDTO refer, @RequestParam String loggedInEmail, Model model){
		String status = referenceService.insertNewReferenceDetails(refer);
		if("Success".equals(status)) {
			return "redirect:/welcome/"+loggedInEmail;
		}
		return "redirect:/welcome/"+loggedInEmail+"?errorStatus="+status;
	}

}
