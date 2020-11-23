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
import com.dh.incognitous.model.entity.FuncionarioPessoaFisica;
import com.dh.incognitous.service.FuncionarioPessoaFisicaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/pessoafisica")
@AllArgsConstructor
public class FuncionarioPessoaFisicaController {

	private final FuncionarioPessoaFisicaService funcionarioPessoaFisicaService;
	
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody FuncionarioPessoaFisica funcionarioPessoaFisica){
		FuncionarioPessoaFisica pessoaFisica= this.funcionarioPessoaFisicaService.create(funcionarioPessoaFisica);
		
		URI uri = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(pessoaFisica.getId())
		.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> update(@PathVariable Long id, @Valid @RequestBody FuncionarioPessoaFisica funcionarioPessoaFisica){
		
		funcionarioPessoaFisica.setId(id);
		this.funcionarioPessoaFisicaService.update(funcionarioPessoaFisica);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Long id){
		Funcionario funcPessoaFisica = this.funcionarioPessoaFisicaService.findById(id);
		return ResponseEntity.ok(funcPessoaFisica);
		
	}
	
	@GetMapping
	public ResponseEntity<List<FuncionarioPessoaFisica>> findAll(){
		
		List<FuncionarioPessoaFisica> allFuncionario = this.funcionarioPessoaFisicaService.findAll();
		return ResponseEntity.ok(allFuncionario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		this.funcionarioPessoaFisicaService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
