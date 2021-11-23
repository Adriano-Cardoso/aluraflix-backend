package br.com.adriano.aluraflix.domain.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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
	
    @NotNull(message = "O campo 'email' no corpo da requisicao")
    @Email(message = "Formato do email esta errado")
    @ApiModelProperty(position = 1, required = false, value = "login do usuario", name = "email", dataType = "String", example = "admin@teste.com")
    private String email;

    @NotNull(message = "O campo 'password' no corpo da requisicao")
    @ApiModelProperty(position = 1, required = false, value = "senha do usuario", name = "password", dataType = "String", example = "12345")
    private String password;

}
