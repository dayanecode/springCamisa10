package com.camisa10fc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camisa10fc.model.Camisa10Alunos;
import com.camisa10fc.repository.Camisa10AlunosRepository;

@Controller
@RequestMapping("/")
public class Camisa10AlunosController {
	
	@Autowired
	private Camisa10AlunosRepository alunosRepository;
	
	
	@GetMapping("/home") 	//endpoint que será informado na URL
	public String home() {
		return "home"; 	//busca o arquivo.html com este nome que estiver dentro de /templates 
	}	
	
	@GetMapping("/listarAlunos") //Método que vai retornar as informações do banco de dados
	public String listarAlunos (Model request) {		
		List<Camisa10Alunos> lista = alunosRepository.findAll(); //o List é o mesmo que um  Select * from SuaTabela definido pelo próprio  framework 
		request.addAttribute("listarAlunos", lista);
		return "listarAlunos";
	}
	
	@GetMapping("/cadastrarAluno")
	public String cadastrarAluno() {
			return "formularioCadastro";
	}
	
	@PostMapping("/formularioNovo")
	public String formularioNovo(Camisa10Alunos requisicao) {
		alunosRepository.save(requisicao);
		return "redirect:/listarAlunos";
	}
		

}
