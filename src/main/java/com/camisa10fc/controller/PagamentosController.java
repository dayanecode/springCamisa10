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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.camisa10fc.model.Alunos;
import com.camisa10fc.model.Pagamentos;
import com.camisa10fc.repository.PagamentosRepository;
import com.camisa10fc.repository.AlunosRepository;

@Controller
@RequestMapping("/")
public class PagamentosController {	
		
	@Autowired //O Spring injeta um objeto do tipo Aluno, ou seja instancia uma "nova classe" automagicamente
	private AlunosRepository alunosRepository;		
	
	@Autowired
	private PagamentosRepository pagamentosRepository;	
	
	//Método que consulta o histórico do aluno antes de incluir o pagamento:
	@GetMapping("/incluirPagamento")
	public String consultarPagamento (Model model) {	
		
		//lista os alunos
		List<Alunos> alunos = alunosRepository.findAll();  
		
		//lista os pagamentos
		List<Pagamentos> pagamentos = pagamentosRepository.findAll(); 		
		
		return "incluirPagamento";
	}	
	
	@PostMapping("/incluirPagamento")
	public ModelAndView pesquisar (@RequestParam("nomePesquisado") String nomePesquisado) {
		ModelAndView modelAndView = new ModelAndView("incluirPagamento");
		//Pesquisa o nome da Tabela Alunos
		modelAndView.addObject("alunos", alunosRepository.findAlunosByName(nomePesquisado.trim()));
		modelAndView.addObject("alunosObj", new Alunos());
		//Pesquisa o nome da Tabela Pagamentos
		modelAndView.addObject("pagamentos", pagamentosRepository.findPagamentosByName(nomePesquisado.trim()));
		modelAndView.addObject("pagamentosObj", new Pagamentos());		
		return modelAndView;	
		
	}
	
	@GetMapping("/inserirPagamento")
	public String pagamento (Model model) {
		model.addAttribute("pagamentos", new Pagamentos());
		return "formularioPagamento";
	}
	
	@PostMapping ("/salvarPagamento")
	public String salvarPagamento(@Valid Pagamentos pagamentos, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) { 
			return "formularioPagamento";
		} 
		pagamentosRepository.save(pagamentos);
		attributes.addFlashAttribute("mensagem", "Pagamento de " + pagamentos.getNome() + " inserido com sucesso!");
		return "redirect:/inserirPagamento";	
	}	
	
	@GetMapping ("/editarPagamento/{id}")	
	public String editarPagamento(@PathVariable("id") long id, Model model) {
		Optional<Pagamentos> pagamentoAnterior = pagamentosRepository.findById(id);
		
		if (!pagamentoAnterior.isPresent() ) {
		throw new IllegalArgumentException("Pagamento não localizado:" + id);	
		} 
		Pagamentos pagamentos = pagamentoAnterior.get();
		model.addAttribute("pagamentos", pagamentos);
		return "salvar-alteracao-pagamento";
		}
	
	@PostMapping("/editarPagamento/{id}")
	public String editarPagamento(@PathVariable("id") long id, @Valid Pagamentos pagamentos, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			pagamentos.setId(id);
			return "salvar-alteracao-pagamento";
		}
		pagamentosRepository.save(pagamentos);
		attributes.addFlashAttribute("mensagemSucesso", "Dados de " + pagamentos.getNome() + " alterados com sucesso!");
		return "redirect:/incluirPagamento";
				
	}
	
	@GetMapping ("/excluirPagamento/{id}")	
	public String excluirPagamento(@PathVariable("id") long id, Model model,  RedirectAttributes attributes) {
		Optional<Pagamentos> pagamentoAnterior = pagamentosRepository.findById(id);		
		Pagamentos pagamentos = pagamentoAnterior.get();
		pagamentosRepository.delete(pagamentos);
		model.addAttribute("pagamentos", pagamentos);
		attributes.addFlashAttribute("mensagemExclusao", "Pagamento de " + pagamentos.getNome() + " excluído do sistema." );
		return "redirect:/incluirPagamento";
		}	


	
}
