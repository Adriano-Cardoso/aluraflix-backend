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
	
	
	@NotBlank(groups={OnCreate.class, OnUpdate.class},message = "O campo 'title' est� inv�lido")
	@NotNull(groups={OnCreate.class, OnUpdate.class},message = "O campo 'title' est� inv�lido")
	@NotEmpty(groups={OnCreate.class, OnUpdate.class},message = "O campo 'title' est� inv�lido")
	@ApiModelProperty(position = 2, required = false, value = "titulo do video", name = "title", dataType = "String", example = "Curso de Java- Iniciando")
	private String title;
	@NotBlank(groups={OnCreate.class, OnUpdate.class},message = "O campo 'description' est� inv�lido")
	@NotNull(groups={OnCreate.class, OnUpdate.class},message = "O campo 'description' est� inv�lido")
	@NotEmpty(groups={OnCreate.class, OnUpdate.class},message = "O campo 'description' est� inv�lido")
	@ApiModelProperty(position = 3, required = false, value = "descricao do video", name = "descricao", dataType = "String", example = "Curso de Java para iniciantes")
	private String description;
	@NotBlank(groups={OnCreate.class, OnUpdate.class},message = "O campo 'url' est� inv�lido")
	@NotNull(groups={OnCreate.class, OnUpdate.class},message = "O campo 'url' est� inv�lido")
	@NotEmpty(groups={OnCreate.class, OnUpdate.class},message = "O campo 'url' est� inv�lido")
	@ApiModelProperty(position = 3, required = false, value = "url do video", name = "url", dataType = "String", example = "http://testewa.com.br")
	private String url;

}
