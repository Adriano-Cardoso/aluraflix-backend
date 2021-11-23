package br.com.adriano.aluraflix.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.adriano.aluraflix.feature.UserScenarioFactory;
import br.com.adriano.aluraflix.service.UserService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {

	@MockBean
	private UserService userService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Criar categoria com titulo valido")
	void CreateCategory_WhenCreateVideoTitleNotExists_ExpectedCreate() throws Exception {
		when(this.userService.save(any())).thenReturn(UserScenarioFactory.USER_RESPONSE);
		mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(UserScenarioFactory.USER_REQUEST))).andExpect(status().isCreated());
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
