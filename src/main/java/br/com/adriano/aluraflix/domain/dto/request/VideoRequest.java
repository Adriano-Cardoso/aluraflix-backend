package br.com.adriano.aluraflix.domain.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.adriano.aluraflix.validations.OnCreate;
import br.com.adriano.aluraflix.validations.OnUpdate;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VideoRequest {
	
	
	@NotBlank(groups={OnCreate.class, OnUpdate.class},message = "O campo 'title' está inválido")
	@NotNull(groups={OnCreate.class, OnUpdate.class},message = "O campo 'title' está inválido")
	@NotEmpty(groups={OnCreate.class, OnUpdate.class},message = "O campo 'title' está inválido")
	@ApiModelProperty(position = 2, required = false, value = "titulo", name = "title", dataType = "String", example = "Curso de Java- Iniciando")
	private String title;
	@NotBlank(groups={OnCreate.class, OnUpdate.class},message = "O campo 'description' está inválido")
	@NotNull(groups={OnCreate.class, OnUpdate.class},message = "O campo 'description' está inválido")
	@NotEmpty(groups={OnCreate.class, OnUpdate.class},message = "O campo 'description' está inválido")
	@ApiModelProperty(position = 3, required = false, value = "descricao", name = "descricao", dataType = "String", example = "Curso de Java para iniciantes")
	private String description;
	@NotBlank(groups={OnCreate.class, OnUpdate.class},message = "O campo 'url' está inválido")
	@NotNull(groups={OnCreate.class, OnUpdate.class},message = "O campo 'url' está inválido")
	@NotEmpty(groups={OnCreate.class, OnUpdate.class},message = "O campo 'url' está inválido")
	@ApiModelProperty(position = 3, required = false, value = "descricao", name = "url", dataType = "String", example = "http://testewa.com.br")
	private String url;

}
