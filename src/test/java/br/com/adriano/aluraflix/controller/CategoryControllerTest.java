//package br.com.adriano.aluraflix.controller;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.web.servlet.MockMvc;
//
//import br.com.adriano.aluraflix.feature.CategoryScenarioFactory;
//import br.com.adriano.aluraflix.feature.VideoScenarioFactory;
//import br.com.adriano.aluraflix.service.CategoryService;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
//@AutoConfigureMockMvc
//public class CategoryControllerTest {
//
//	@MockBean
//	private CategoryService categoryService;
//
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
//	@DisplayName("Listar todos os vídeos")
//	public void listaAllCategory_WhenListIsValid_ExpectedOk() throws Exception {
//		when(this.categoryService.listAllCategory()).thenReturn(CategoryScenarioFactory);
//		this.mockMvc.perform(get("/videos")).andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
//}
