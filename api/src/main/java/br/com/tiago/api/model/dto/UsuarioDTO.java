package br.com.tiago.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private Integer id;
	private String name;
	private String email;
	
	//Nesse caso só vai libera para escrita e não para leitura.
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
}
