package br.com.adriano.aluraflix.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoResponse {
	
	private Long id;
	private String titulo;
	private String descricao;
	private String url;

}
