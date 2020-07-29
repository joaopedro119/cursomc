package com.joaopedro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaopedro.cursomc.domain.Categoria;
import com.joaopedro.cursomc.repositories.CategoriaRepository;
import com.joaopedro.cursomc.services.exceptions.ObjectNotFoundException;

@Service	
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		 if(obj == null) {
			 throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					 +", Tipo: " + Categoria.class.getName());
		 }
		return obj.orElse(null); 
	}
	
	
}
