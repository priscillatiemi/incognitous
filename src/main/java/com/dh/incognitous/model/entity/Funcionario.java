package com.dh.incognitous.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="funcionario")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_funcionario")
public class Funcionario implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@Column(nullable = false, length = 60)
	
	@Size(min = 6, max = 60)
	private String nome;
	
	@Column(nullable = false, length = 120)
	
	@Size(min = 6, max = 120)
	private String endereco;
	
	@Column(nullable = false, length = 11, unique = true)
	
	@CPF
	@NotNull
	private String cpf;
	
	@Column(nullable = false, length = 60, unique = true)
	
	@Email
	private String email;
	
	@Column(nullable = false, length = 60)
	
	@Size(min = 6, max = 60)
	private String setor;
	
	@Column(nullable = false )
	
	private LocalDate dataAdmissao;
	
	@Column(nullable = false)
	
	private LocalDate dataDemissao;
	
	@Column(nullable = false )
	
	private double salario;
	
	@Column(nullable=false)
	
	private double bonificacao;
	
	
	
}
