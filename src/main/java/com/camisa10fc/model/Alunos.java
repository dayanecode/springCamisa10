package com.camisa10fc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity //Define que a nossa classe será uma tabela do banco de dados
public class Alunos {
	@Id //Atributo que se tornará chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // FUNCIONA COM O MYSQL Gerar ID automagicamente
	private Long id;
	
	@NotNull
	@Size(min =3, message = "O nome do aluno deve conter mais de dois dígitos")
	private String nome_aluno;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date data_nasc;
	
	private int idade;
	
	@NotEmpty (message = "Selecione a categoria")
	private String categoria;
	
	@NotEmpty (message = "Selecione a turma")
	private String turma;
	
	@NotEmpty (message = "Selecione o período")
	private String periodo;

	private String rg;
	
	private String cpf;
	
	@NotEmpty (message = "Informe o nome do responsável pelo aluno")
	private String responsavel;
	
	@NotEmpty (message = "Informe o telefone para contato")
	private String telefone;
	
	private String observacoes;	
	private String situacao = "ATIVO";
		
		
	public Alunos() {
		super();
	}

	public Alunos(Long id, String nome_aluno, Date data_nasc, int idade, String categoria, String turma, String periodo, String rg,
			String cpf, String responsavel, String telefone, String observacoes, String situacao) {
		super();
		this.id = id;
		this.nome_aluno = nome_aluno;
		this.data_nasc = data_nasc;
		this.idade = idade;
		this.categoria = categoria;
		this.turma = turma;
		this.turma = periodo;
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
	
	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}
		
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
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
		Alunos other = (Alunos) obj;
		if (id == null) {	
		if (other.id != null)
			return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

		
}
