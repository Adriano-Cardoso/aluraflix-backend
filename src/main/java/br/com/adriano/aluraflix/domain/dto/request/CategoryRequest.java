package br.com.adriano.aluraflix.domain.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	

	@NotBlank(groups={OnCreate.class, OnUpdate.class},message = "O campo 'title' esta invalido")
	@NotNull(groups={OnCreate.class, OnUpdate.class},message = "O campo 'title' esta invalido")
	@NotEmpty(groups={OnCreate.class, OnUpdate.class},message = "O campo 'title' esta invalido")
	@ApiModelProperty(position = 2, required = false, value = "titulo da categoria", name = "title", dataType = "String", example = "categoria 1")
	private String title;

	@NotBlank(groups={OnCreate.class, OnUpdate.class},message = "O campo 'color' esta invalido")
	@NotNull(groups={OnCreate.class, OnUpdate.class},message = "O campo 'color' esta invalido")
	@NotEmpty(groups={OnCreate.class, OnUpdate.class},message = "O campo 'color' esta invalido")
	@ApiModelProperty(position = 2, required = false, value = "cor da categoria", name = "cpçpr", dataType = "String", example = "Vermelho")
	private String color;
	

}
