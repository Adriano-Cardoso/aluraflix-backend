package br.com.adriano.aluraflix.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class LoginResponse {

	@ApiModelProperty(position = 1, required = false, value = "token do login", name = "token", dataType = "String", example = "asjdj489284u29ur938hd3jd")
	private String token;

	@ApiModelProperty(position = 2, required = false, value = "tipo do token do login", name = "titulo", dataType = "String", example = "Bearer")
	private String type;

}
