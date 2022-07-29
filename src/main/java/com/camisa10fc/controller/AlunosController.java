package com.camisa10fc.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.camisa10fc.model.Alunos;
import com.camisa10fc.repository.AlunosRepository;

@Controller
@RequestMapping("/")
public class AlunosController {
	
	@Autowired //O Spring injeta um objeto do tipo Aluno, ou seja instancia uma "nova classe" automagicamente
	private AlunosRepository alunosRepository;
	
	
	@GetMapping("/") 	//endpoint que será informado na URL
	public String home() {
		return "home"; 	//busca o arquivo.html com este nome que estiver dentro de /templates 
	}	
	
	@GetMapping("/listarAlunos") //Método que vai retornar as informações do banco de dados
	public String listarAlunos (Model model) {		
		List<Alunos> lista = alunosRepository.findAll(); //o List é o mesmo que um  Select * from SuaTabela definido pelo próprio  framework 
		model.addAttribute("listarAlunos", lista);
		return "listarAlunos";
	}

	@GetMapping("/cadastrarAluno")
	public String adicionarAluno(Model model) {
		model.addAttribute("alunos", new Alunos());
		return "formularioCadastro";
	}
	
	@PostMapping ("/salvar")
	public String salvarAluno(@Valid Alunos alunos, BindingResult result,
				RedirectAttributes attributes) {
		if (result.hasErrors()) { //verifica se existe algum erro na validação dos dados
			return "formularioCadastro";
		} 
		alunosRepository.save(alunos);
		attributes.addFlashAttribute("mensagem", "Aluno inserido com sucesso!");
		return "redirect:/cadastrarAluno";
//		return "redirect:/listarAlunos";
		
	}

}
