package br.com.tiago.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.tiago.api.model.Usuario;
import br.com.tiago.api.repository.UsuarioRepository;

@Configuration
@Profile("local")
public class LocalConfig {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Bean
	public void startDB() {
		Usuario u1 = new Usuario(null, "Tiago", "tiago@gmail.com", "123");
		Usuario u2 = new Usuario(null, "Fulano", "fulano@gmail.com", "456");
		
		usuarioRepository.saveAll(List.of(u1, u2));
	}
}
