package br.com.tiago.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiago.api.model.Usuario;
import br.com.tiago.api.model.dto.UsuarioDTO;
import br.com.tiago.api.repository.UsuarioRepository;
import br.com.tiago.api.service.UsuarioService;
import br.com.tiago.api.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	//Método create convertendo DTO para Entidade.
	@Override
	public Usuario create(UsuarioDTO obj) {
		return usuarioRepository.save(mapper.map(obj, Usuario.class));
	}
	
}
