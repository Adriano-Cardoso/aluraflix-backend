package br.com.adriano.aluraflix.domain.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import br.com.adriano.aluraflix.validations.OnUpdate;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VideoUpdateRequest {

	@NotBlank(groups = { OnUpdate.class }, message = "O campo 'description' esta invalido")
	@NotNull(groups = { OnUpdate.class }, message = "O campo 'description' esta invalido")
	@NotEmpty(groups = { OnUpdate.class }, message = "O campo 'description' esta invalido")
	@ApiModelProperty(position = 1, required = false, value = "descricao do video", name = "descricao", dataType = "String", example = "Curso de Java para iniciantes")
	private String description;

	@URL(groups = { OnUpdate.class }, message = "O campo 'url' esta invalido")
	@ApiModelProperty(position = 2, required = false, value = "url do video", name = "url", dataType = "String", example = "http://testewa.com.br")
	private String url;

}
