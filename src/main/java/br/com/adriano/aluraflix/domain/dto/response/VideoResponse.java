package br.com.adriano.aluraflix.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoResponse {
	
	@ApiModelProperty(position = 1, required = false, value = "id do produto", name = "videoId", dataType = "Long", example = "1")
	private Long videoId;
	@ApiModelProperty(position = 2, required = false, value = "titulo do video", name = "title", dataType = "String", example = "Curso de Java- Iniciando")
	private String title;
	@ApiModelProperty(position = 3, required = false, value = "descricao do video", name = "description", dataType = "String", example = "Curso de Java para iniciantes")
	private String description;
	@ApiModelProperty(position = 4, required = false, value = "url do video", name = "url", dataType = "String", example = "http://testewa.com.br")
	private String url;
	
	

}
