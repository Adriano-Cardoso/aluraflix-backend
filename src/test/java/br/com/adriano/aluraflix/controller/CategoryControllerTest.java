package br.com.adriano.aluraflix.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.adriano.aluraflix.feature.CategoryScenarioFactory;
import br.com.adriano.aluraflix.service.CategoryService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureMockMvc
public class CategoryControllerTest {

	@MockBean
	private CategoryService categoryService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Listar todos as categorias")
	void listaAllCategory_WhenListIsValid_ExpectedOk() throws Exception {
		when(this.categoryService.listAllCategory()).thenReturn(CategoryScenarioFactory.LIST_ALL_CATEGORY);
		this.mockMvc.perform(get("/categorias")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@DisplayName("pesquisar categoria por id")
	void findByCategoryId_WhenIdIsValid_ExpectedSucess() throws Exception {
		when(this.categoryService.finByCategoryId(1L)).thenReturn(CategoryScenarioFactory.CATEGORY_RESPONSE);
		this.mockMvc.perform(get("/categorias/1")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@DisplayName("Criar categoria com titulo valido")
	void CreateCategory_WhenCreateVideoTitleNotExists_ExpectedCreate() throws Exception {
		when(this.categoryService.createCategory(any())).thenReturn(CategoryScenarioFactory.CATEGORY_RESPONSE);
		this.mockMvc.perform(post("/categorias").content(asJsonString(CategoryScenarioFactory.CREATE_CATEGORY))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}

	@Test
	@DisplayName("Atualizar Categoria")
	void update_WhenUpdateCategoryIdIsValid_ExpectedSucess() throws Exception {
		when(this.categoryService.finByCategoryId(any())).thenReturn(CategoryScenarioFactory.CATEGORY_RESPONSE);
		this.mockMvc
				.perform(patch("/categorias/1").content(asJsonString(CategoryScenarioFactory.CATEGORY_UPDATE_REQUEST))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}
	@Test
	@DisplayName("Deletar Categoria")
	void delete_WhenDeleteCategory_ExpectedSucess() throws Exception {
		doNothing().when(categoryService).delete(1L);
		
		mockMvc.perform(delete("/categorias/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}

	@Test
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
