package br.com.adriano.aluraflix.feature;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import br.com.adriano.aluraflix.domain.Category;
import br.com.adriano.aluraflix.domain.Video;
import br.com.adriano.aluraflix.domain.dto.request.VideoRequest;
import br.com.adriano.aluraflix.domain.dto.request.VideoUpdateRequest;
import br.com.adriano.aluraflix.domain.dto.response.VideoResponse;

public class VideoScenarioFactory {

	public static final Page<VideoResponse> LIST_ALL = loadVideos();
	public static final Video FIND_BY_ID = loadByIdVideo();
	public static final VideoResponse FIND_VIDEOS = findVideos();
	public static final VideoUpdateRequest VIDEO_UPDATE = updateRequest();
	public static final VideoRequest CREATE_REQUEST = createNewRequest();
	public static final VideoResponse VIDEO_RESPONSE = createExistsControllerResponse();
	public static final Category CATEGORY = loadCategory();
	public static final Video VIDEO = loadVideo();
	public static final Page<VideoResponse> FIND_ALL = loadFindAll();

	private static Page<VideoResponse> loadVideos() {
		PageRequest page = PageRequest.of(0, 10);

		VideoResponse videoResponse = new VideoResponse(4L, "Curso de Java- Iniciando", "Curso de Java para iniciantes",
				"http://testewa.com.br", 1L);

		List<VideoResponse> list = new ArrayList<>();
		list.add(videoResponse);
		return new PageImpl<>(list, page, 10);
	}

	private static Page<VideoResponse> loadFindAll() {
		PageRequest page = PageRequest.of(0, 10);

		VideoResponse video = new VideoResponse(4L, "Curso de Java- Iniciando", "Curso de Java para iniciantes",
				"http://testewa.com.br", 1L);

		List<VideoResponse> list = new ArrayList<>(); 

		list.add(video);

		return new PageImpl<>(list, page, 10);
	}

	private static Video loadVideo() {
		Video video = new Video(1L, "title", "description", "http://teste.com", 1L, CategoryScenarioFactory.CATEGORY);

		return video;
	}

	private static Category loadCategory() {

		return new Category(1L, "Categori 1", "");
	}

	private static VideoResponse createExistsControllerResponse() {
		VideoResponse videoResponse = new VideoResponse(1L, "teste 01", "teste", "teste", 2L);
		return videoResponse;
	}

	private static VideoRequest createNewRequest() {
		return VideoRequest.builder().title("teste").description("teste 01").url("teste").categoryId(1L).build();
	}

	private static VideoUpdateRequest updateRequest() {
		VideoUpdateRequest videoRequest = new VideoUpdateRequest("Curso de banco de dados", "http://testesbd.com");
		return videoRequest;
	}

	private static VideoResponse findVideos() {
		VideoResponse video = new VideoResponse(4L, "Curso de Agil", "Curso iniciante", "http://testewa.com.br", 1L);
		return video;
	}

	public static Video loadByIdVideo() {
		Video video = new Video();

		video.getVideoId();
		video.getTitle();
		video.getDescription();
		video.getUrl();
		video.getCategory();

		return video;
	}

}
