package br.com.adriano.aluraflix.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.adriano.aluraflix.domain.dto.request.VideoRequest;
import br.com.adriano.aluraflix.domain.dto.response.VideoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@Table(name = "VIDEO")
@AllArgsConstructor
@NoArgsConstructor
public class Videos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "TITULO", length = 30)
	private String titulo;
	@Column(name = "DESCRICAO", length = 20)
	private String descricao;
	@Column(name = "URL", length = 50)
	private String url;

	public VideoResponse toDto() {
		return VideoResponse.builder().id(this.id).titulo(this.titulo).descricao(this.descricao).url(this.url).build();
	}

	public static Videos of(VideoRequest videoRequest) {
		return Videos.builder().titulo(videoRequest.getTitulo()).descricao(videoRequest.getDescricao())
				.url(videoRequest.getUrl()).build();

	}

}
