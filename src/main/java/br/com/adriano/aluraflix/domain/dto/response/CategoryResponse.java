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
public class CategoryResponse {
	
	@ApiModelProperty(position = 1, required = false, value = "id da Categoria", name = "categoryId", dataType = "Long", example = "1")
	private Long categoryId;
	@ApiModelProperty(position = 2, required = false, value = "titulo da categoria", name = "titulo", dataType = "String", example = "Basico")
	private String title;
	@ApiModelProperty(position = 3, required = false, value = "cor da categoria", name = "color", dataType = "String", example = "Vermelho")
	private String color;

}
