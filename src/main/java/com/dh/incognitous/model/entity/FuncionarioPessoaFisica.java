package com.dh.incognitous.model.entity;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@DiscriminatorValue("pessoa_fisica")

public class FuncionarioPessoaFisica extends Funcionario{

	
	@Column(nullable = false, length = 60)
	@Size(min=6, max= 60)
	private String nit;
	
	
}
