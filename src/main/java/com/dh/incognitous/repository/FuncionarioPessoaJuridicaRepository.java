package com.dh.incognitous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dh.incognitous.model.entity.Funcionario;

@Repository
public interface FuncionarioPessoaJuridicaRepository extends JpaRepository<Funcionario, Long>{

}
