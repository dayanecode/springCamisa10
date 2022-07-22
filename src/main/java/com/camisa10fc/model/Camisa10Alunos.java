package com.camisa10fc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
public class Camisa10Alunos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // FUNCIONA COM O MYSQL
	private Long id;
	

	private String nome_aluno;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data_nasc;
	private int idade;
	private String categoria;
	private String rg;
	private String cpf;
	private String responsavel;
	private String telefone;
	private String observacoes;	
	private String situacao;
		
		
	public Camisa10Alunos() {
		super();
	}

	public Camisa10Alunos(Long id, String nome_aluno, Date data_nasc, int idade, String categoria, String rg,
			String cpf, String responsavel, String telefone, String observacoes, String situacao) {
		super();
		this.id = id;
		this.nome_aluno = nome_aluno;
		this.data_nasc = data_nasc;
		this.idade = idade;
		this.categoria = categoria;
		this.rg = rg;
		this.cpf = cpf;
		this.responsavel = responsavel;
		this.telefone = telefone;
		this.observacoes = observacoes;
		this.situacao = situacao;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome_aluno() {
		return nome_aluno;
	}
	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}
	public Date getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}	
	
	@Override
	public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;		
		Camisa10Alunos other = (Camisa10Alunos) obj;
		if (id == null) {	
		if (other.id != null)
			return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
	
	
	
	
		

}
