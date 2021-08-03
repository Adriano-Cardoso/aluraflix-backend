package br.com.adriano.aluraflix.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.adriano.aluraflix.domain.dto.response.CategoryResponse;
import br.com.adriano.aluraflix.exception.BusinessException;
import br.com.adriano.aluraflix.feature.CategoryScenarioFactory;
import br.com.adriano.aluraflix.repository.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
	
	@InjectMocks
	private CategoryService categoryService;
	
	@Mock
	private CategoryRepository categoryRepository;
	
	
	@Test
	@DisplayName("Listar todas categorias")
	void list_WhenListAllValid_ExpectedSucess() {
		when(this.categoryRepository.listAllCategory()).thenReturn(CategoryScenarioFactory.LIST_ALL_CATEGORY);
		List<CategoryResponse> categoryResponse = categoryService.listAllCategory();
		assertNotNull(categoryResponse);
	} 
	@Test
	@DisplayName("Listar categoria por titulo valido")
	void findByTitle_WhenTitleIsValid_ExpectedSucess() {
		when(this.categoryRepository.findByTitle(any())).thenReturn(Optional.of(CategoryScenarioFactory.FIND_BY_TITLE));
		
		assertNotNull(this.categoryService.findByTitle(any()));
		
		verify(categoryRepository).findByTitle(any());
	}
	
	@Test
	@DisplayName("Listar categoria por titulo invalido")
	void findByTitle_WhenTitleInValid_ExpectedException() {
		when(this.categoryRepository.findByTitle(any())).thenReturn(Optional.empty());
		
		assertThrows(BusinessException.class, () -> this.categoryService.findByTitle("tittle"));
		
		verify(categoryRepository).findByTitle(any());
	}
	
	@Test
	@DisplayName("Listar categoria por id valido")
	void findById_WhenIdIsValid_ExpectedSucess() {
		when(this.categoryRepository.findById(any())).thenReturn(Optional.of(CategoryScenarioFactory.CATEGORY_ID_VALID));
		
		assertNotNull(this.categoryService.finByCategoryId(any()));
		
		verify(categoryRepository).findById(any());
	}
	
	@Test
	@DisplayName("Listar categoria por id invalido")
	void findById_WhenIdInValid_ExpectedException() {
		when(this.categoryRepository.findById(any())).thenReturn(Optional.empty());
		
		assertThrows(BusinessException.class, () -> this.categoryService.finByCategoryId(10L));
		
		verify(categoryRepository).findById(any());
	}

	@Test
	@DisplayName("criar categoria com titulo valido")
	void create_WhenCreateCategoryTitleNotExistents_ExpectedSucess() {
		when(this.categoryRepository.findByTitle(any())).thenReturn(Optional.empty());
		when(this.categoryRepository.save(any())).thenReturn(CategoryScenarioFactory.CATEGORY);
		
		CategoryResponse categoryResponse = categoryService.createCategory(CategoryScenarioFactory.CREATE_CATEGORY);
		
		assertNotNull(categoryResponse);

		verify(categoryRepository).save(any());
	
	}
	
	@Test
	@DisplayName("criar categoria com titulo valido")
	void create_WhenCreateCategoryTitleExistents_ExpectedException() {
		when(this.categoryRepository.findByTitle(any())).thenReturn(Optional.of(CategoryScenarioFactory.CATEGORY));
		assertThrows(BusinessException.class, () -> categoryService.createCategory(CategoryScenarioFactory.CREATE_CATEGORY));
	}
	
	@Test
	@DisplayName("atualizar categoria com id valido")
	void update_WhenUpdateIdIsValid_ExpectedSucess() {
		when(this.categoryRepository.findById(any())).thenReturn(Optional.of(CategoryScenarioFactory.CATEGORY));
		CategoryResponse categoryResponse = this.categoryService.updateCategory(1L, CategoryScenarioFactory.CATEGORY_UPDATE_REQUEST);
		assertNotNull(categoryResponse);

		verify(categoryRepository).findById(any());
	}
	
	@Test
	@DisplayName("atualizar categoria com id invalido")
	void update_WhenUpdateIdInValid_ExpectedException() {
		when(this.categoryRepository.findByTitle(any())).thenReturn(Optional.empty());
		assertThrows(BusinessException.class, () -> categoryService.updateCategory(10L,CategoryScenarioFactory.CATEGORY_UPDATE_REQUEST));
	}
	

	@Test
	@DisplayName("Deletar id valido")
	void delete_WhenIdValid_ExpectedSucess() {
		when(this.categoryRepository.findById(any())).thenReturn(Optional.of(CategoryScenarioFactory.CATEGORY_ID_VALID));

		this.categoryService.delete(1L);
	}

	@Test
	@DisplayName("Deletar  id invalido")
	void delete_WhenIdIsInValid_ExpectedExceprion() {
		when(this.categoryRepository.findById(any())).thenReturn(Optional.empty());

		assertThrows(BusinessException.class, () -> this.categoryService.delete(7L));
	}

	
}
