package br.com.adriano.aluraflix.feature;

import java.util.ArrayList;
import java.util.List;

import br.com.adriano.aluraflix.domain.Category;
import br.com.adriano.aluraflix.domain.dto.request.CategoryRequest;
import br.com.adriano.aluraflix.domain.dto.response.CategoryResponse;

public class CategoryScenarioFactory {

	public static final Category CATEGORY = loadCategory();
	public static final CategoryResponse CATEGORY_RESPONSE = loadCategoryResponse();
	public static final List<CategoryResponse> LIST_ALL_CATEGORY = loadListCategory();
	public static final Category FIND_BY_TITLE = loadTitleValid();
	public static final Category CATEGORY_ID_VALID = loadCategoryByIdValid();
	public static final CategoryRequest CREATE_CATEGORY = CreateCategoryRequest();
	public static final CategoryRequest CATEGORY_UPDATE_REQUEST = updateCategoryRequest();

	private static Category loadCategory() {
		Category category = new Category(1L, "title", "color");
		return category;
	}




	private static CategoryResponse loadCategoryResponse() {

		return new CategoryResponse(1L, "title", "color");
	}

	private static List<CategoryResponse> loadListCategory() {
		CategoryResponse category = new CategoryResponse(1L, "title", "color");
		List<CategoryResponse> CategoryResponse = new ArrayList<>();
		CategoryResponse.add(category);
		return CategoryResponse;
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
}
