package br.com.adriano.aluraflix.domain.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import br.com.adriano.aluraflix.validations.OnCreate;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequest {

	@NotNull(groups = { OnCreate.class }, message = "O campo 'email' no corpo da requisicao")
	@Email(groups = { OnCreate.class }, message = "Formato do email esta errado")
	@ApiModelProperty(position = 1, required = false, value = "email do usuario", name = "email", dataType = "String", example = "aluno@teste.com")
	private String email;

	@ApiModelProperty(position = 2, required = false, value = "username do usuario", name = "username", dataType = "String", example = "Aluno")
	@NotNull(groups = { OnCreate.class }, message = "O campo 'username' no corpo da requisicao")
	private String username;

	@ApiModelProperty(position = 3, required = false, value = "password do usuario", name = "password", dataType = "String", example = "12345")
	@NotNull(groups = { OnCreate.class }, message = "O campo 'password' no corpo da requisicao")
	private String password;

}
