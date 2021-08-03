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

import br.com.adriano.aluraflix.domain.dto.response.VideoResponse;
import br.com.adriano.aluraflix.exception.BusinessException;
import br.com.adriano.aluraflix.feature.CategoryScenarioFactory;
import br.com.adriano.aluraflix.feature.VideoScenarioFactory;
import br.com.adriano.aluraflix.repository.VideoRepository;

@ExtendWith(MockitoExtension.class)
public class VideoServiceTest {

	@InjectMocks
	private VideoService videoService;

	@Mock
	private VideoRepository videoRepository;

	@Mock
	private CategoryService categoryService;

	@Test
	@DisplayName("Listar todos os videos")
	void listAllVideos_WhenListValid_ExpectedOk() {
		when(this.videoRepository.findAllVideos()).thenReturn(VideoScenarioFactory.LIST_ALL);

		List<VideoResponse> listAllVideos = this.videoService.listAllVideos();

		assertNotNull(listAllVideos);
 
	}

	@Test
	@DisplayName("Pesquisar pelo id valido")
	void ListByIdVideo_WhenIdValid_expectedOk() {
		when(this.videoRepository.findById(any())).thenReturn(Optional.of(VideoScenarioFactory.VIDEO));

		assertNotNull(this.videoService.findByVideoId(1L));

		verify(videoRepository).findById(any());
	}

	@Test
	@DisplayName("Pesquisar pelo id invalido")
	void ListByIdVideo_WhenIdIsInValid_expectedException() {
		when(this.videoRepository.findById(any())).thenReturn(Optional.empty());
		assertThrows(BusinessException.class, () -> this.videoService.findByVideoId(7L));

	}

	@Test
	@DisplayName("Deletar id valido")
	void delete_WhenIdValid_ExpectedDelete() {
		when(this.videoRepository.findById(any())).thenReturn(Optional.of(VideoScenarioFactory.FIND_BY_ID));

		this.videoService.delete(3L);
	}

	@Test
	@DisplayName("Deletar  id invalido")
	void delete_WhenIdIsInValid_ExpectedDelete() {
		when(this.videoRepository.findById(any())).thenReturn(Optional.empty());

		assertThrows(BusinessException.class, () -> this.videoService.delete(7L));
	}

	@Test
	@DisplayName("Criar video com parametros validos")
	void create_WhenNotExistsTitle_ExpectedCreate() {

		when(this.videoRepository.save(any())).thenReturn(VideoScenarioFactory.VIDEO);

		when(this.videoRepository.findByTitle(any())).thenReturn(Optional.empty());

		when(this.categoryService.findByTitle(any())).thenReturn(CategoryScenarioFactory.CATEGORY);

		VideoResponse save = videoService.create(VideoScenarioFactory.CREATE_REQUEST);

		assertNotNull(save);

		verify(videoRepository).findByTitle(any());

		verify(videoRepository).save(any());

	}

	@Test
	@DisplayName("Criar video com titulo com parametros invalidos")
	void create_WhenExistsTitle_ExpectedNotCreate() {

		when(this.videoRepository.findByTitle(any())).thenReturn(Optional.of(VideoScenarioFactory.FIND_VIDEOS));

		assertThrows(BusinessException.class, () -> videoService.create(VideoScenarioFactory.CREATE_REQUEST));

	}

	@Test
	@DisplayName("Atualizar parametros  com id valido")
	void update_WhenExistisId_ExpectedUpdate() {

		when(this.videoRepository.findById(any())).thenReturn(Optional.of(VideoScenarioFactory.VIDEO));

		VideoResponse videoUpdate = this.videoService.update(1L, VideoScenarioFactory.VIDEO_UPDATE);

		assertNotNull(videoUpdate);
	}

	@Test
	@DisplayName("Atualizar parametros e url com id invalido")
	void update_WhenNotExistisId_ExpectedNotUpdate() {

		when(this.videoRepository.findById(any())).thenReturn(Optional.empty());

		assertThrows(BusinessException.class, () -> videoService.update(10L, VideoScenarioFactory.VIDEO_UPDATE));
	}

}
