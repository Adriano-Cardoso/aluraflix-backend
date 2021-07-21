package br.com.adriano.aluraflix.domain.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import br.com.adriano.aluraflix.validations.OnCreate;
import br.com.adriano.aluraflix.validations.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VideoUpdateRequest {
	
	@NotBlank(groups={OnCreate.class, OnUpdate.class},message = "O campo 'description' está inválido")
	@NotNull(groups={OnCreate.class, OnUpdate.class},message = "O campo 'description' está inválido")
	@NotEmpty(groups={OnCreate.class, OnUpdate.class},message = "O campo 'description' está inválido")
	private String description;
	@URL(groups={OnCreate.class, OnUpdate.class},message = "O campo 'description' está inválido")
	private String url;

}
