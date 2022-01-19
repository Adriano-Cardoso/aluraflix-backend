package br.com.adriano.aluraflix.domain.dto.request;

import javax.validation.constraints.NotEmpty;

import br.com.adriano.aluraflix.validations.OnCreate;
import br.com.adriano.aluraflix.validations.OnUpdate;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CategoryRequest {
	

	@NotEmpty(groups={OnCreate.class, OnUpdate.class},message = "O campo 'title' esta invalido, no corpo da requisicao")
	@ApiModelProperty(position = 1, required = false, value = "titulo da categoria", name = "title", dataType = "String", example = "Terror")
	private String title;

	@NotEmpty(groups={OnCreate.class, OnUpdate.class},message = "O campo 'color' esta invalido, no corpo da requisicao")
	@ApiModelProperty(position = 2, required = false, value = "cor da categoria", name = "color", dataType = "String", example = "Vermelho")
	private String color;
	

}
