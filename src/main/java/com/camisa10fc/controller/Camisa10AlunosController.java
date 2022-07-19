package com.camisa10fc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camisa10fc.repository.Camisa10AlunosRepository;

@Controller
@RequestMapping("/")
public class Camisa10AlunosController {
	
	@Autowired
	private Camisa10AlunosRepository camisa10alunosRepository;
	
	
	@GetMapping("/home") 	//endpoint que será informado na URL
	public String home() {
		return "home"; 	
	}	
	
	
	
	
	
	

}
