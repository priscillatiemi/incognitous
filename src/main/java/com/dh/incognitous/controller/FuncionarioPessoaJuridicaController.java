package com.dh.incognitous.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dh.incognitous.model.entity.Funcionario;
import com.dh.incognitous.model.entity.FuncionarioPessoaJuridica;
import com.dh.incognitous.service.FuncionarioPessoaJuridicaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/pessoajuridica")
@AllArgsConstructor
public class FuncionarioPessoaJuridicaController {

private final FuncionarioPessoaJuridicaService funcionarioPessoaJuridicaService;
	
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody FuncionarioPessoaJuridica funcionarioPessoaJuridica){
		FuncionarioPessoaJuridica pessoaJuridica= this.funcionarioPessoaJuridicaService.create(funcionarioPessoaJuridica);
		
		URI uri = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(pessoaJuridica.getId())
		.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> update(@PathVariable Long id, @Valid @RequestBody FuncionarioPessoaJuridica funcionarioPessoaJuridica){
		
		funcionarioPessoaJuridica.setId(id);
		this.funcionarioPessoaJuridicaService.update(funcionarioPessoaJuridica);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Long id){
		Funcionario funcPessoaJuridica = this.funcionarioPessoaJuridicaService.findById(id);
		return ResponseEntity.ok(funcPessoaJuridica);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll(){
		
		List<Funcionario> allFuncionario = this.funcionarioPessoaJuridicaService.findAll();
		return ResponseEntity.ok(allFuncionario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		this.funcionarioPessoaJuridicaService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
