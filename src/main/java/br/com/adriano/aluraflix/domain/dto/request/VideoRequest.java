package br.com.adriano.aluraflix.domain.dto.request;

import javax.validation.constraints.NotBlank;

import br.com.adriano.aluraflix.validations.OnCreate;
import br.com.adriano.aluraflix.validations.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VideoRequest {
	
	@NotBlank(groups={OnCreate.class, OnUpdate.class},message = "O campo 'titulo' deve ser informado")
	private String titulo;
	@NotBlank(groups={OnCreate.class, OnUpdate.class},message = "O campo 'titulo' deve ser informado")
	private String descricao;
	@NotBlank(groups={OnCreate.class, OnUpdate.class},message = "O campo 'titulo' deve ser informado")
	private String url;

}
