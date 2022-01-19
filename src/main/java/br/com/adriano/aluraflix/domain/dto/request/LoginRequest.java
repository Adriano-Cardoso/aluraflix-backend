package br.com.adriano.aluraflix.domain.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import br.com.adriano.aluraflix.validations.OnCreate;
<<<<<<< HEAD
import br.com.adriano.aluraflix.validations.OnUpdate;
=======
>>>>>>> feature/semana-3
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class LoginRequest {
<<<<<<< HEAD

	@NotNull(groups = { OnCreate.class, OnUpdate.class }, message = "O campo 'email' no corpo da requisicao")
	@Email(groups = { OnCreate.class, OnUpdate.class }, message = "Formato do email esta errado")
	@ApiModelProperty(position = 1, required = false, value = "email do usuario", name = "email", dataType = "String", example = "admin@email.com")
	private String email;

	@NotNull(groups = { OnCreate.class, OnUpdate.class }, message = "O campo 'password' no corpo da requisicao")
	@ApiModelProperty(position = 1, required = false, value = "senha do usuario", name = "password", dataType = "String", example = "12345")
	private String password;
=======
	
	@NotNull(groups = {OnCreate.class}, message = "O campo 'email' esta incorreto no corpo da requisicao")
	@Email(groups = {OnCreate.class}, message = "Formato do campo 'email'esta incorreto no corpo da requisicao")
    @ApiModelProperty(position = 1, required = false, value = "login do usuario", name = "email", dataType = "String", example = "aluno@teste.com")
    private String email;

	@NotNull(groups = {OnCreate.class}, message = "O campo 'password' esta incorreto no corpo da requisicao!")
    @ApiModelProperty(position = 1, required = false, value = "senha do usuario", name = "password", dataType = "String", example = "123456")
    private String password;
>>>>>>> feature/semana-3

}
