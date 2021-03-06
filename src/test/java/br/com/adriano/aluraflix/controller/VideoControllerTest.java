package br.com.adriano.aluraflix.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.adriano.aluraflix.feature.VideoScenarioFactory;
import br.com.adriano.aluraflix.service.VideoService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class VideoControllerTest {

	@MockBean
	private VideoService videoService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Listar todos os videos")
	public void listaAllVideos_WhenListIsValid_ExpectedOk() throws Exception {
		when(this.videoService.listAllVideos(anyInt(), anyInt(), any())).thenReturn(VideoScenarioFactory.FIND_ALL);
		this.mockMvc.perform(get("/videos")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@DisplayName("Listar todos os free")
	public void free_WhenListIsValid_ExpectedOk() throws Exception {
		when(this.videoService.free()).thenReturn(VideoScenarioFactory.FIND_ALL);
		this.mockMvc.perform(get("/videos/free")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@DisplayName("Listar todos por categoria")
	public void cateogry_WhenListIsValid_ExpectedOk() throws Exception {
		when(this.videoService.listByCategory(anyInt(), anyInt(), anyLong())).thenReturn(VideoScenarioFactory.FIND_ALL);
		this.mockMvc.perform(get("/videos/4/categorias")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@DisplayName("Lista videos pelo Id")
	public void findVideoId_WhenIdIsValid_ExpectedOk() throws Exception {
		when(this.videoService.findByVideoId(4L)).thenReturn(VideoScenarioFactory.FIND_VIDEOS);
		this.mockMvc.perform(get("/videos/4")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@DisplayName("Criar novo video com nome valido")
	public void createVideo_WhenCreateVideoTitleNotExists_ExpectedCreate() throws Exception {

		when(this.videoService.create(any())).thenReturn(VideoScenarioFactory.VIDEO_RESPONSE);
		this.mockMvc.perform(post("/videos").content(asJsonString(VideoScenarioFactory.CREATE_REQUEST))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}

	@Test
	@DisplayName("Atualiza videos com id invalido")
	public void updateVideo_WhenUpdateVideoIdExists_ExpectedUpdate() throws Exception {

		when(this.videoService.update(anyLong(), any())).thenReturn(VideoScenarioFactory.VIDEO_RESPONSE);

		mockMvc.perform(patch("/videos/4").content(asJsonString(VideoScenarioFactory.VIDEO_UPDATE))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	@DisplayName("deletar videos com id valido")
	public void delete_WhenPathVariableIsValid_ExpectedOk() throws Exception {

		doNothing().when(videoService).delete(4L);

		mockMvc.perform(delete("/videos/4").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}

	@Test
	@DisplayName("deletar videos com Id valido")
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
