package com.dh.incognitous.model.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@DiscriminatorValue("pessoa_juridica")

public class FuncionarioPessoaJuridica extends Funcionario {


	@Column(nullable = true, length = 60)
	@CNPJ
	private String cnpj;
	
}
