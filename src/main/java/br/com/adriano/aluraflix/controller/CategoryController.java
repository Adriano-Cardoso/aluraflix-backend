package br.com.adriano.aluraflix.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adriano.aluraflix.domain.dto.request.CategoryRequest;
import br.com.adriano.aluraflix.domain.dto.response.CategoryResponse;
import br.com.adriano.aluraflix.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(value = "Categoria Endpoint", description = "Endpoints para categoria dos videos", tags = { "categoria Endpoint" })
@RestController
@AllArgsConstructor
@RequestMapping("/categorias")
public class CategoryController {

	private CategoryService categoryService;

	@ApiOperation(value = "Listar categorias")
	@GetMapping
	public ResponseEntity<Page<CategoryResponse>> listAllCategory() {
		return ResponseEntity.status(HttpStatus.OK).body(this.categoryService.listAllCategory());
	}

	@ApiOperation(value = "buscar categoria por id")
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryResponse> findByCategoryId(@PathVariable("categoryId") Long categoryId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.categoryService.finByCategoryId(categoryId));

	}

	@ApiOperation(value = "criar nova categoria")
	@PostMapping
	public ResponseEntity<CategoryResponse> create(@Valid @RequestBody CategoryRequest categoryRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.categoryService.createCategory(categoryRequest));
	}

	@ApiOperation(value = "Atualizar categoria por id categoria")
	@PatchMapping("/{categoryId}")
	public ResponseEntity<CategoryResponse> updateCategory(@Valid @PathVariable("categoryId") Long categoryId,
			@Valid @RequestBody CategoryRequest categoryRequest) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.categoryService.updateCategory(categoryId, categoryRequest));

	}

	@ApiOperation(value = "deletar categoria")
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<CategoryResponse> delete(@Valid @PathVariable("categoryId") Long categoryId) {
		this.categoryService.delete(categoryId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
