package br.com.adriano.aluraflix.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.adriano.aluraflix.domain.Category;
import br.com.adriano.aluraflix.domain.dto.request.CategoryRequest;
import br.com.adriano.aluraflix.domain.dto.response.CategoryResponse;
import br.com.adriano.aluraflix.repository.CategoryRepository;
import br.com.adriano.aluraflix.validations.Message;
import br.com.adriano.aluraflix.validations.OnCreate;
import br.com.adriano.aluraflix.validations.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Validated
@AllArgsConstructor
public class CategoryService {

	private CategoryRepository categoryRepository;

	public Page<CategoryResponse> listAllCategory() {
		int limit = 3;
		int page = 0;

		log.info("method=listAllCategory");

		Pageable pageable = PageRequest.of(page, limit);

		log.info("method=listAllCategory limit{}", limit);

		return this.categoryRepository.listAllCategory(pageable);

	}

	public Category findByTitle(String title) {
		log.info("method=findByTitle title={}", title);

		return this.categoryRepository.findByTitle(title)
				.orElseThrow(() -> Message.CATEGORY_TITLE_EXIST.asBusinessException());
	}

	public CategoryResponse finByCategoryId(Long categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> Message.NOT_FOUND_ID.asBusinessException());
		log.info("method=finByCategoryId categoryId={}", categoryId);

		return category.toDto();
	}

	@Validated(OnCreate.class)
	public CategoryResponse createCategory(@Valid CategoryRequest categoryRequest) {
		this.categoryRepository.findByTitle(categoryRequest.getTitle()).ifPresent(t -> {
			throw Message.CATEGORY_EXIST.asBusinessException();
		});

		Category category = Category.of(categoryRequest);

		this.categoryRepository.save(category);

		log.info("method=createCategory categoryId={} title={} color={}", category.getCategoryId(), category.getTitle(),
				category.getColor());

		return category.toDto();

	}

	@Validated(OnUpdate.class)
	@Transactional
	public CategoryResponse updateCategory(Long categoryId, @Valid CategoryRequest categoryRequest) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(Message.NOT_FOUND_ID::asBusinessException);

		category.update(categoryRequest);
		log.info("method=update updateCategory={} title={} color={}", categoryId, category.getTitle(),
				category.getColor());
		return category.toDto();

	}

	public void delete(Long categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(Message.NOT_FOUND_ID::asBusinessException);

		this.categoryRepository.delete(category);
		log.info("method=delete categoryId={}", category.getCategoryId());

	}

	public Category findById(Long categoryId) {

		log.info("method=findById");
		return categoryRepository.findById(categoryId)
				.orElseThrow(() -> Message.NOT_FOUND_CATEGORY.asBusinessException());
	}
}
