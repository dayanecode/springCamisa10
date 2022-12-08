package com.camisa10fc.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Pagamentos {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty (message = "O nome do aluno não pode ser vazio")
	@NotNull (message = "Aluno não localizado")
	@NotBlank (message = "Campo não informado")
	@Pattern (regexp = "([a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]+\\s?)+", message = "O nome não pode conter números nem caracteres especiais.") 
	private String nome;
	
	@NotNull (message = "Insira o valor pago")
	private BigDecimal valor;
	
	
	@Temporal(TemporalType.DATE) //sem esta opção o campo vira DateTime no Banco de Dados
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private Date data_pagamento;

	@NotEmpty(message = "Insira a forma de pagamento")
	@NotBlank (message = "Campo não informado")
	private String forma_pagamento;
	
	@NotEmpty (message = "Insira a referência")
	@NotBlank (message = "Campo não informado")
	private String referencia;	

	private String observacoes;
	
	private String comprovante;	
	
	//@Temporal(TemporalType.DATE) // Isso converte a data em dia, mês e ano e elimina as horas minutos e segundos etc.
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private Date dataInclusao = new java.util.Date();
		
	private String usuarioInclusao = "system";		
		
	public Pagamentos() {
		super();
	}
	
	
	public Pagamentos(Long id,
			@NotEmpty(message = "O nome do aluno não pode ser vazio") @NotNull(message = "Aluno não localizado") String nome,
			@NotNull(message = "Insira o valor pago") BigDecimal valor, Date data_pagamento,
			@NotEmpty(message = "Insira a forma de pagamento") String forma_pagamento,
			@NotEmpty(message = "Insira a referência") String referencia, String observacoes, String comprovante,
			Date dataInclusao, String usuarioInclusao) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.data_pagamento = data_pagamento;
		this.forma_pagamento = forma_pagamento;
		this.referencia = referencia;
		this.observacoes = observacoes;
		this.comprovante = comprovante;
		this.dataInclusao = dataInclusao;
		this.usuarioInclusao = usuarioInclusao;
	}



	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public String getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}


	public String getComprovante() {
		return comprovante;
	}


	public void setComprovante(String comprovante) {
		this.comprovante = comprovante;
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
		Pagamentos other = (Pagamentos) obj;
		if (id == null) {	
		if (other.id != null)
			return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
		
	
}
