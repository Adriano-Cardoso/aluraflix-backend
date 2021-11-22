package br.com.adriano.aluraflix.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.adriano.aluraflix.domain.dto.request.VideoRequest;
import br.com.adriano.aluraflix.domain.dto.request.VideoUpdateRequest;
import br.com.adriano.aluraflix.domain.dto.response.VideoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "TB_VIDEO")
@Entity
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "video_id", nullable = false)
	private Long videoId;

	@Column(name = "titulo", length = 100, nullable = false)
	private String title;

	@Column(name = "descricao", length = 100, nullable = false)
	private String description;

	@Column(name = "url", length = 100, nullable = false)
	private String url;

	@Column(name = "categoria_id", nullable = true, insertable = false, updatable = false)
	private Long categoryId;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
	private Category category;

	public VideoResponse toDto() {
		return VideoResponse.builder().videoId(this.videoId).title(this.title).description(this.description)
				.url(this.url).categoryId(this.category.getCategoryId()).build();
	}

	public static Video of(VideoRequest videoRequest) {
		return Video.builder().title(videoRequest.getTitle()).description(videoRequest.getDescription())
				.url(videoRequest.getUrl()).build();

	}
	

	public void addCategory(Category category) {
		this.category = category;
		this.categoryId = category.getCategoryId();

	}

	public void update(VideoUpdateRequest videoUpdateRequestRequest) {

		this.description = videoUpdateRequestRequest.getDescription();

		this.url = videoUpdateRequestRequest.getUrl();

	}

}
