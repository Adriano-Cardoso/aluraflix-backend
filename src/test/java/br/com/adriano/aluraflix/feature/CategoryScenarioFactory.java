package br.com.adriano.aluraflix.feature;

import br.com.adriano.aluraflix.domain.Category;

public class CategoryScenarioFactory {

	public static final Category CATEGORY = loadCategory();

	private static Category loadCategory() {
		Category category = new Category(1L, "title", "color");
		return category;
	}
}
