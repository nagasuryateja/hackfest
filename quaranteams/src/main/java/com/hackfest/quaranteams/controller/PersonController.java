package com.hackfest.quaranteams.controller;

import com.hackfest.quaranteams.entity.Person;
import com.hackfest.quaranteams.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRespository;
	
	@GetMapping("/sample")
	public String samplePerson(){
		System.out.println("in sample person method");
		return "call succeeded";
	}
	
	
	@PostMapping("/savePerson")
	public Person savePerson(@RequestBody Person person){
		System.out.println("in save person method");
		return personRespository.addPerson(person);
	}
	
	@GetMapping("/getPerson/{personId}")
	public Person getPerson(@PathVariable String personId){
		System.out.println("in get person method");
		return personRespository.findPersonByPersonId(personId);
	}
	
	@DeleteMapping("/deletePerson")
	public String deletePerson(@RequestBody Person person){
		System.out.println("in delete person method");
		return personRespository.deletePerson(person);
	}
	
	@PostMapping("/editPerson")
	public String editPerson(@RequestBody Person person){
		System.out.println("in edit person method");
		return personRespository.editPerson(person);
	}
	
}
