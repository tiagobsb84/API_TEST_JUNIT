package br.com.tiago.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiago.api.model.Usuario;
import br.com.tiago.api.service.UsuarioService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(usuarioService.findById(id)); 
	}
}
