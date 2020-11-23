package com.dh.incognitous.service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dh.incognitous.exceptions.ArgumentNotValidException;
import com.dh.incognitous.exceptions.ObjectNotFoundException;
import com.dh.incognitous.model.entity.Funcionario;
import com.dh.incognitous.model.entity.FuncionarioPessoaFisica;
import com.dh.incognitous.repository.FuncionarioPessoaFisicaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioPessoaFisicaService {

	private final FuncionarioPessoaFisicaRepository funcionarioPessoaFisicaRepository;
	
	
	public FuncionarioPessoaFisica create(FuncionarioPessoaFisica funcionarioPessoaFisica) {
		return this.funcionarioPessoaFisicaRepository.save(funcionarioPessoaFisica);
	}
	
	public FuncionarioPessoaFisica update(FuncionarioPessoaFisica funcionarioPessoaFisica) {
		findById(funcionarioPessoaFisica.getId());
		return this.funcionarioPessoaFisicaRepository.save(funcionarioPessoaFisica);
	}
	
	public Funcionario findById(Long id) {
		Optional
			.ofNullable(id)	
			.orElseThrow(()->new ArgumentNotValidException("ID nao pode ser nulo"));
	
		return this.funcionarioPessoaFisicaRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Funcionario de id: "+id+" nao foi encontrado"));
	}
	
	
	public List<FuncionarioPessoaFisica> findAll(){
		return this.funcionarioPessoaFisicaRepository.findAll();
	}
	
	public void delete(Long id) {
		this.findById(id);
		this.funcionarioPessoaFisicaRepository.deleteById(id);
	}
	
	public void getSalario() {
		
	}
}
