package br.com.tiago.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tiago.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
