package com.generation.lojagames.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.lojagames.model.Produto;
import com.generation.lojagames.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Optional<Produto> curtir(Long id){
		
		if(produtoRepository.existsById(id)) {
			
			var produto = produtoRepository.findById(id).get();
			
			produto.setCurtir(produto.getCurtir() + 1);
			
			return Optional.of(produtoRepository.save(produto));
		}
		
		return Optional.empty();
	}
}
