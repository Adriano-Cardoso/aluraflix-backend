package br.com.adriano.aluraflix.domain.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequest {
	
	@NotNull(message = "O campo 'email' no corpo da requisicao")
	@Email(message = "Formato do email esta errado")
	private String email;
	@NotNull(message = "O campo 'username' no corpo da requisicao")
	private String username;
	@NotNull(message = "O campo 'password' no corpo da requisicao")
	private String password;

}
