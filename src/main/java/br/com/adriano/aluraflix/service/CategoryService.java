package br.com.adriano.aluraflix.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.adriano.aluraflix.domain.Category;
import br.com.adriano.aluraflix.domain.dto.request.CategoryRequest;
import br.com.adriano.aluraflix.domain.dto.response.CategoryResponse;
import br.com.adriano.aluraflix.repository.CategoryRepository;
import br.com.adriano.aluraflix.validations.Message;
import br.com.adriano.aluraflix.validations.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class CategoryService {

	private CategoryRepository categoryRepository;

	public List<CategoryResponse> listAllCategory() {

		log.info("method=listAllCategory");
		return this.categoryRepository.listAllCategory();

	}
 
	public Category findByTitle(String title) {
		log.info("method=findByTitle title={}", title);
		
		return this.categoryRepository.findByTitle(title).orElseThrow(() -> Message.CATEGORY_TITLE_EXIST.asBusinessException());
	}

	public CategoryResponse finByCategoryId(Long categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> Message.NOT_FOUND_ID.asBusinessException());
		log.info("method=findByVideoId videoId={}", categoryId);

		return category.toDto();
	}

	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
		this.categoryRepository.findByTitle(categoryRequest.getTitle()).ifPresent(t -> {
			throw Message.CATEGORY_EXIST.asBusinessException();
		});

		Category category = Category.of(categoryRequest);

		this.categoryRepository.save(category);

		log.info("method=create categoryId={} title={} color={}", category.getCategoryId(), category.getTitle(),
				category.getColor());

		return category.toDto();

	}

	@Validated(OnUpdate.class)
	@Transactional
	public CategoryResponse updateCategory(Long CategoryId, @Valid CategoryRequest categoryRequest) {
		Category category = this.categoryRepository.findById(CategoryId)
				.orElseThrow(Message.NOT_FOUND_ID::asBusinessException);

		category.update(categoryRequest);
		log.info("method=update CategoryId={} title={} color={}", CategoryId, category.getTitle(), category.getColor());
		return category.toDto();

	}

	public void delete(Long categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(Message.NOT_FOUND_ID::asBusinessException);

		this.categoryRepository.delete(category);
		log.info("method=delete videoId={}", category.getCategoryId());

	}
}
