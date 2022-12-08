package com.camisa10fc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.camisa10fc.model.Alunos;
import com.camisa10fc.repository.AlunosRepository;
import com.camisa10fc.repository.PagamentosRepository;

@Controller
@RequestMapping("/")
public class AlunosController {
	
	@Autowired //O Spring injeta um objeto do tipo Aluno, ou seja instancia uma "nova classe" automagicamente
	private AlunosRepository alunosRepository;
	
	
	@Autowired //O Spring injeta um objeto do tipo Aluno, ou seja instancia uma "nova classe" automagicamente
	private PagamentosRepository pagamentosRepository;
	
	
	@GetMapping("/") 	//endpoint que será informado na URL
	public String home() {
		return "home"; 	//busca o arquivo.html com este nome que estiver dentro de /templates 
	}	

	@GetMapping("/cadastrarAluno")
	public String adicionarAluno(Model model) {
		model.addAttribute("alunos", new Alunos());
		return "formularioCadastro";
	}
	
	@PostMapping ("/salvar")
	public String salvarAluno(@Valid Alunos alunos, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) { //verifica se existe algum erro na validação dos dados
			return "formularioCadastro";
		} 
		alunosRepository.save(alunos);
		attributes.addFlashAttribute("mensagem", alunos.getNome() + " inserido(a) com sucesso!");
		return "redirect:/cadastrarAluno";
		
	}
	
	@GetMapping ("/editarAluno/{id}")	
	public String editarAluno(@PathVariable("id") long id, Model model) {
		Optional<Alunos> alunoAnterior = alunosRepository.findById(id);
		
		if (!alunoAnterior.isPresent() ) {
		throw new IllegalArgumentException("Aluno não localizado:" + id);	
		} 	
		
		Alunos alunos = alunoAnterior.get();
		model.addAttribute("alunos", alunos);
		return "salvar-alteracao-aluno";
	}

	@PostMapping("/editarAluno/{id}")
	public String editarAluno(@PathVariable("id") long id, @Valid Alunos alunos, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			alunos.setId(id);
			return "salvar-alteracao-aluno";
		}
		alunosRepository.save(alunos);
		attributes.addFlashAttribute("mensagemSucesso", "Dados de " + alunos.getNome() + " alterados com sucesso!");
		return "redirect:/incluirPagamento";
				
	}
	

}
