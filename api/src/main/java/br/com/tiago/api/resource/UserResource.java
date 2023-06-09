package br.com.tiago.api.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tiago.api.model.dto.UsuarioDTO;
import br.com.tiago.api.service.UsuarioService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(mapper.map(usuarioService.findById(id), UsuarioDTO.class)); 
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		return ResponseEntity.ok().body(usuarioService.findAll()
				.stream().map(x -> mapper.map(x, UsuarioDTO.class)).collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO obj) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioService.create(obj).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
