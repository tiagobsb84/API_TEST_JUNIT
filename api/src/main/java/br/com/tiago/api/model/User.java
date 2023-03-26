package br.com.tiago.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data ele já tem o @Gette e @Setter, o ruim diminui a perfomace mas como e poucos atributos.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	//unique o email tem que ser unico do usuario
	@Column(unique = true)
	private String email;
	private String password;
}
