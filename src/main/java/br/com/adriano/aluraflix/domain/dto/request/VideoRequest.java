package br.com.adriano.aluraflix.domain.dto.request;

import javax.validation.constraints.NotEmpty;

import br.com.adriano.aluraflix.validations.OnCreate;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoRequest {
	
	@NotEmpty(groups = {OnCreate.class}, message = "O campo 'title' esta invalido  no corpo da requisicao")
	@ApiModelProperty(position = 2, required = false, value = "titulo do video", name = "title", dataType = "String", example = "Curso de Java- Iniciando")
	private String title;
	
	@NotEmpty(groups = {OnCreate.class}, message = "O campo 'description' esta invalido  no corpo da requisicao")
	@ApiModelProperty(position = 3, required = false, value = "descricao do video", name = "descricao", dataType = "String", example = "Curso de Java para iniciantes")
	private String description;
	
	@NotEmpty(groups = {OnCreate.class}, message = "O campo 'url' esta invalido no corpo da requisicao ")
	@ApiModelProperty(position = 3, required = false, value = "url do video", name = "url", dataType = "String", example = "http://testewa.com.br")
	private String url;
	
	@ApiModelProperty(position = 3, required = false, value = "categoria do video", name = "categoryId", dataType = "Long", example = "1")
	private Long categoryId;

}
