package br.com.adriano.aluraflix.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.adriano.aluraflix.domain.Category;
import br.com.adriano.aluraflix.domain.dto.response.CategoryResponse;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("select new br.com.adriano.aluraflix.domain.dto.response.CategoryResponse(c.categoryId, c.title, c.color) From Category c")
	List<CategoryResponse> listAllCategory();
    
	
	Optional<Category> findByTitle(String title);

}
