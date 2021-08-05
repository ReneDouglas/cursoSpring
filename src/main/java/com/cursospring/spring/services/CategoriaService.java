package com.cursospring.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.spring.domain.Categoria;
import com.cursospring.spring.repositories.CategoriaRepository;
import com.cursospring.spring.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		
	}
	
	public Categoria insert(Categoria obj) {
		//o obj novo a ser inserido tem q ter o Id nulo, senao o save considerará que é uma atualização
		obj.setId(null);
		return repo.save(obj);
	}

}
