package br.com.adriano.aluraflix.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.adriano.aluraflix.domain.dto.request.CategoryRequest;
import br.com.adriano.aluraflix.domain.dto.response.CategoryResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_categoria")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoria_id", nullable = false)
	private Long categoryId;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "titulo", nullable = false)
	private String title;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cor", nullable = false)
	private String color;

	public CategoryResponse toDto() {
		return CategoryResponse.builder().categoryId(this.categoryId).title(this.title).color(this.color).build();
	}

	public static Category of(CategoryRequest categoryRequest) {
		return Category.builder().title(categoryRequest.getTitle()).color(categoryRequest.getColor()).build();
	}

	public void update(CategoryRequest categoryRequest) {
		this.title = categoryRequest.getTitle();
		this.color = categoryRequest.getColor();

	}

}
