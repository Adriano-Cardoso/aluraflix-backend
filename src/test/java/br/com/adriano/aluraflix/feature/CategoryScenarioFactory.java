package br.com.adriano.aluraflix.feature;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import br.com.adriano.aluraflix.domain.Category;
import br.com.adriano.aluraflix.domain.dto.request.CategoryRequest;
import br.com.adriano.aluraflix.domain.dto.response.CategoryResponse;

public class CategoryScenarioFactory {

	public static final Category CATEGORY = loadCategory();
	public static final CategoryResponse CATEGORY_RESPONSE = loadCategoryResponse();
	public static final Page<CategoryResponse> LIST_ALL_CATEGORY = loadListCategory();
	public static final Category FIND_BY_TITLE = loadTitleValid();
	public static final Category CATEGORY_ID_VALID = loadCategoryByIdValid();
	public static final CategoryRequest CREATE_CATEGORY = CreateCategoryRequest();
	public static final CategoryRequest CATEGORY_UPDATE_REQUEST = updateCategoryRequest();
	public static final CategoryResponse CATEGORY_RESPONSE_CONTROLLER = loadCategoryResponseController();
	public static final CategoryRequest CREATE = createRequestController();

	private static Category loadCategory() {
		Category category = new Category(1L, "title", "color");
		return category;
	}


	private static CategoryResponse loadCategoryResponse() {

		return new CategoryResponse(1L, "title", "color");
	}

	private static Page<CategoryResponse> loadListCategory() {
		PageRequest page = PageRequest.of(0, 10);

		CategoryResponse categoryResponse = new CategoryResponse(1L, "title", "color");

		List<CategoryResponse> list = new ArrayList<>();
		list.add(categoryResponse);
		return new PageImpl<>(list, page, 10);
		
	}

	private static Category loadTitleValid() {
		Category category = new Category(1L, "title", "color");
		return category;
	}

	private static Category loadCategoryByIdValid() {
		Category category = new Category(2L, "title1", "color1");

		return category;
	}

	private static CategoryRequest CreateCategoryRequest() {
		CategoryRequest categoryRequest = new CategoryRequest("title", "color");
		return categoryRequest;
	}

	private static CategoryRequest updateCategoryRequest() {
		CategoryRequest categoryRequest = new CategoryRequest("title", "color");
		return categoryRequest;
	}

	private static CategoryResponse loadCategoryResponseController() {
		CategoryResponse categoryResponse = new CategoryResponse(3L, "titulo", "cor");
		return categoryResponse;
	}
	private static CategoryRequest createRequestController() {
		CategoryRequest categoryRequest = new CategoryRequest("title", "color");
		return categoryRequest;
	}
}
