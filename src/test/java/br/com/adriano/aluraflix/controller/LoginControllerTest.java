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

import br.com.adriano.aluraflix.feature.LoginScenarioFactory;
import br.com.adriano.aluraflix.service.LoginService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class LoginControllerTest {

	@MockBean
	private LoginService loginService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Criar categoria com titulo valido")
	public void auth_WhenRequestIsValid_ExpectedCreate() throws Exception {

		when(loginService.auth(any())).thenReturn(LoginScenarioFactory.LOGIN_RESPONSE);

		mockMvc.perform(post("/auth").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(LoginScenarioFactory.LOGIN_RESPONSE))).andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
