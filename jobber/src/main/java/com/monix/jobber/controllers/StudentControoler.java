package com.monix.jobber.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControoler {

    @GetMapping(value = "/hello")
	public String helloWorld(){
		return "Hello world ....";
	}
}