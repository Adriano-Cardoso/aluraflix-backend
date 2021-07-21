package br.com.adriano.aluraflix.feature;

import java.util.ArrayList;
import java.util.List;

import br.com.adriano.aluraflix.domain.Video;
import br.com.adriano.aluraflix.domain.dto.request.VideoRequest;
import br.com.adriano.aluraflix.domain.dto.request.VideoUpdateRequest;
import br.com.adriano.aluraflix.domain.dto.response.VideoResponse;

public class VideoScenarioFactory {

	public static final VideoRequest REQUEST = createRequest();
	public static final List<VideoResponse> LIST_ALL = loadVideos();
	public static final Video FIND_BY_ID = loadByIdVideo();
	public static final VideoResponse FIND_VIDEOS = findVideos();
	public static final VideoRequest REQUEST_EXISTS = createExistsRequest();
	public static final VideoUpdateRequest UPDATE = updateRequest();
	public static final Video VIDEOS = createVideos();
	public static final VideoRequest CREATE_REQUEST = createNewRequest();

	private static List<VideoResponse> loadVideos() {
		VideoResponse video = new VideoResponse();
		List<VideoResponse> list = new ArrayList<>();
		video.getVideoId();
		video.getTitle();
		video.getDescription();
		video.getUrl();
		list.add(video);
		return list;
	}

	private static VideoRequest createNewRequest() {
		VideoRequest request = new VideoRequest("Curso de kambam", "Curso iniciante", "http://test.com");
		return request;
	}

	private static Video createVideos() {
		Video video = new Video(5L, "Curso de Scrum", "Curso iniciante", "http://testewa.com.br");

		return video;
	}

	private static VideoRequest createRequest() {
		return VideoRequest.builder().title("titulo").description("descricao")
				.url("http://test.com.br").build();
	}

	private static VideoUpdateRequest updateRequest() {
		VideoUpdateRequest video = new VideoUpdateRequest("Curso de banco de dados", "http://testesbd.com");
		return video;
	}

	private static VideoRequest createExistsRequest() {

		return VideoRequest.builder().title("Curso de Python- Iniciando").description("Curso de Java para iniciantes")
				.url("http://testewa.com.br").build();
	}

	private static VideoResponse findVideos() {
		VideoResponse video = new VideoResponse(4L, "Curso de Agil", "Curso iniciante", "http://testewa.com.br");

		return video;
	}

	public static Video loadByIdVideo() {
		Video video = new Video();

		video.getVideoId();
		video.getTitle();
		video.getDescription();
		video.getUrl();

		return video;
	}

}
