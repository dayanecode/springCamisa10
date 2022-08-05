package com.camisa10fc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.camisa10fc.model.Alunos;

public interface AlunosRepository extends JpaRepository<Alunos, Long> {

	@Query("select a from Alunos a where a.nome like %?1%")
	List<Alunos> findAlunosByName (String nome);
}
