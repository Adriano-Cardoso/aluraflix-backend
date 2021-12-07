package br.com.adriano.aluraflix.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.adriano.aluraflix.domain.Category;
import br.com.adriano.aluraflix.domain.dto.response.CategoryResponse;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("select new br.com.adriano.aluraflix.domain.dto.response.CategoryResponse(c.categoryId, c.title, c.color) From Category c")
	Page<CategoryResponse> listAllCategory(Pageable page);

	Optional<Category> findByTitle(String title);

}
