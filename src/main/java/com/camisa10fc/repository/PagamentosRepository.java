package com.camisa10fc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.camisa10fc.model.Pagamentos;

public interface PagamentosRepository extends JpaRepository<Pagamentos, Long> {

		@Query("select p from Pagamentos p where p.nome like %?1%")
		List<Pagamentos> findPagamentosByName (String nome);
}
