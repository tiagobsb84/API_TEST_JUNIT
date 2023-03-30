package br.com.tiago.api.service;

import java.util.List;

import br.com.tiago.api.model.Usuario;

public interface UsuarioService {

	Usuario findById(Integer id);
	
	List<Usuario> findAll();
}
