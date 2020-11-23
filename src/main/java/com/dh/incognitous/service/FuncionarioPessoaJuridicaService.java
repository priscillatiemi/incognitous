package com.dh.incognitous.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dh.incognitous.exceptions.ArgumentNotValidException;
import com.dh.incognitous.exceptions.ObjectNotFoundException;
import com.dh.incognitous.model.entity.Funcionario;
import com.dh.incognitous.model.entity.FuncionarioPessoaJuridica;
import com.dh.incognitous.repository.FuncionarioPessoaJuridicaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioPessoaJuridicaService {

	private final FuncionarioPessoaJuridicaRepository funcionarioPessoaJuridicaRepository;
	
	public FuncionarioPessoaJuridica create(FuncionarioPessoaJuridica funcionarioPessoaJuridica) {
		return this.funcionarioPessoaJuridicaRepository.save(funcionarioPessoaJuridica);
	}
	
	public FuncionarioPessoaJuridica update(FuncionarioPessoaJuridica funcionarioPessoaJuridica) {
		findById(funcionarioPessoaJuridica.getId());
		return this.funcionarioPessoaJuridicaRepository.save(funcionarioPessoaJuridica);
	}
	
	public Funcionario findById(Long id) {
		Optional
			.ofNullable(id)	
			.orElseThrow(()->new ArgumentNotValidException("ID nao pode ser nulo"));
	
		return this.funcionarioPessoaJuridicaRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Funcionario de id: "+id+" nao foi encontrado"));
	}
	
	
	public List<Funcionario> findAll(){
		return this.funcionarioPessoaJuridicaRepository.findAll();
	}
	
	public void delete(Long id) {
		this.findById(id);
		this.funcionarioPessoaJuridicaRepository.deleteById(id);
	}
}
