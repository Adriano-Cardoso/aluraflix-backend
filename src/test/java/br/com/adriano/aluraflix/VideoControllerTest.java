package br.com.adriano.aluraflix;

import static org.mockito.ArgumentMatchers.any;
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
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.adriano.aluraflix.feature.VideoScenarioFactory;
import br.com.adriano.aluraflix.service.VideoService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureMockMvc
public class VideoControllerTest {

	@MockBean
	private VideoService videoService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Listar todos os vídeos")
	public void listaAllVideos_WhenListIsValid_ExpectedOk() throws Exception {
		when(this.videoService.listAllVideos()).thenReturn(VideoScenarioFactory.LIST_ALL);
		this.mockMvc.perform(get("/videos")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@DisplayName("Lista vídeos pelo Id")
	public void findVideoId_WhenIdIsValid_ExpectedOk() throws Exception {
		when(this.videoService.findByVideoId(4L)).thenReturn(VideoScenarioFactory.FIND_VIDEOS);
		this.mockMvc.perform(get("/videos/4")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	@DisplayName("Criar novo vídeos com nome válido")
	public void createVideo_WhenCreateVideoTitleNotExists_ExpectedCreate() throws Exception {

		when(this.videoService.create(any())).thenReturn(VideoScenarioFactory.VIDEO_RESPONSE);
		this.mockMvc.perform(post("/videos").content(asJsonString(VideoScenarioFactory.CREATE_REQUEST))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}

	@Test
	@DisplayName("Atualiza vídeos com Id v�válido")
	public void updateVideo_WhenUpdateVideoIdExists_ExpectedUpdate() throws Exception {

		when(this.videoService.update(anyLong(), any())).thenReturn(VideoScenarioFactory.VIDEO_RESPONSE);

		mockMvc.perform(patch("/videos/4").content(asJsonString(VideoScenarioFactory.VIDEO_UPDATE))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	@DisplayName("deletar vídeos com Id válido")
	public void delete_WhenPathVariableIsValid_ExpectedOk() throws Exception {

		doNothing().when(videoService).delete(4L);

		mockMvc.perform(delete("/videos/4").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}

	@Test
	@DisplayName("deletar vídeos com Id válido")
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
