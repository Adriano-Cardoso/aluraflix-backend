package br.com.adriano.aluraflix.feature;

import java.util.ArrayList;
import java.util.List;

import br.com.adriano.aluraflix.domain.Category;
import br.com.adriano.aluraflix.domain.Video;
import br.com.adriano.aluraflix.domain.dto.request.CategoryRequest;
import br.com.adriano.aluraflix.domain.dto.request.VideoRequest;
import br.com.adriano.aluraflix.domain.dto.request.VideoUpdateRequest;
import br.com.adriano.aluraflix.domain.dto.response.CategoryResponse;
import br.com.adriano.aluraflix.domain.dto.response.VideoResponse;

public class VideoScenarioFactory {

	public static final List<VideoResponse> LIST_ALL = loadVideos();
	public static final Video FIND_BY_ID = loadByIdVideo();
	public static final VideoResponse FIND_VIDEOS = findVideos();
	public static final VideoUpdateRequest VIDEO_UPDATE = updateRequest();
	public static final VideoRequest CREATE_REQUEST = createNewRequest();
	public static final VideoResponse VIDEO_RESPONSE = createExistsControllerRequest();
	public static final Category CATEGORY = loadCategory();
	public static final Video VIDEO = loadVideo();

	private static List<VideoResponse> loadVideos() {
		VideoResponse video = new VideoResponse(4L, "Curso de Java- Iniciando", "Curso de Java para iniciantes",
				"http://testewa.com.br", 1L, "Azul", "Catgoria 1");
		List<VideoResponse> list = new ArrayList<>();
		list.add(video);
		return list;
	}

	private static Video loadVideo() {
		  Video video = new Video(1L, "title", "description", "http://teste.com", 1L, CategoryScenarioFactory.CATEGORY);

	        return video;
	}

	private static Category loadCategory() {
		
		return new Category(1L, "Categori 1", "");
	}

	private static VideoResponse createExistsControllerRequest() {
		VideoResponse videoResponse = new VideoResponse(4L, "Curso de QA", "Aprendnedo QA", "http://test.com", 1L,
				"Azul", "Catgoria 1");
		return videoResponse;
	}

	private static VideoRequest createNewRequest() {
		VideoRequest videoRequest = new VideoRequest("Curso de QA", "Aprendnedo QA", "http://test.com",
				new CategoryRequest("1234", "1234"));
		return videoRequest;
	}

	private static VideoUpdateRequest updateRequest() {
		VideoUpdateRequest videoRequest = new VideoUpdateRequest("Curso de banco de dados", "http://testesbd.com");
		return videoRequest;
	}

	private static VideoResponse findVideos() {
		VideoResponse video = new VideoResponse(4L, "Curso de Agil", "Curso iniciante", "http://testewa.com.br",
				new CategoryResponse(2L, "Categoria 2", "Branca"));

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
