package com.hackfest.quaranteams.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackfest.quaranteams.entity.BankDetails;
import com.hackfest.quaranteams.entity.BasicDetails;
import com.hackfest.quaranteams.entity.InputData;
import com.hackfest.quaranteams.entity.Person;
import com.hackfest.quaranteams.repository.VerificationRepository;

@RestController
@RequestMapping("/userdetails")
public class VerificationController {
	
	@Autowired
	private VerificationRepository verificationRepository;
	
	@PostMapping("/saveUserDetails")
	public BasicDetails savePerson(@RequestBody BasicDetails details){
		System.out.println("in save person method");
		return verificationRepository.addUserDetails(details);
	}
	
	@PostMapping("/fetchUserDetails")
	public BasicDetails getPerson(@RequestBody BasicDetails details){
		System.out.println("in get person method");
		return verificationRepository.fetchUserDetails(details.getAadhar(), details.getPancard());
	}

}
