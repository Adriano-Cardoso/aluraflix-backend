package br.com.adriano.aluraflix.domain.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import br.com.adriano.aluraflix.validations.OnCreate;
import br.com.adriano.aluraflix.validations.OnUpdate;
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

	@NotNull(groups = { OnCreate.class, OnUpdate.class }, message = "O campo 'email' no corpo da requisicao")
	@Email(groups = { OnCreate.class, OnUpdate.class }, message = "Formato do email esta errado")
	@ApiModelProperty(position = 1, required = false, value = "email do usuario", name = "email", dataType = "String", example = "admin@email.com")
	private String email;

	@NotNull(groups = { OnCreate.class, OnUpdate.class }, message = "O campo 'password' no corpo da requisicao")
	@ApiModelProperty(position = 1, required = false, value = "senha do usuario", name = "password", dataType = "String", example = "12345")
	private String password;

}
