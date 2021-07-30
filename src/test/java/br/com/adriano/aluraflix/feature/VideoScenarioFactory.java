package br.com.adriano.aluraflix.feature;

import java.util.ArrayList;
import java.util.List;

import br.com.adriano.aluraflix.domain.Video;
import br.com.adriano.aluraflix.domain.dto.request.VideoRequest;
import br.com.adriano.aluraflix.domain.dto.request.VideoUpdateRequest;
import br.com.adriano.aluraflix.domain.dto.response.VideoResponse;

public class VideoScenarioFactory {

	public static final List<VideoResponse> LIST_ALL = loadVideos();
	public static final Video FIND_BY_ID = loadByIdVideo();
	public static final VideoResponse FIND_VIDEOS = findVideos();
	public static final VideoUpdateRequest VIDEO_UPDATE = updateRequest();
//	public static final Video VIDEOS = createVideos();
	public static final VideoRequest CREATE_REQUEST = createNewRequest();
	public static final VideoResponse VIDEO_RESPONSE = createExistsControllerRequest();

	private static List<VideoResponse> loadVideos() {
		VideoResponse video = new VideoResponse(4L, "Curso de Java- Iniciando", "Curso de Java para iniciantes",
				"http://testewa.com.br");
		List<VideoResponse> list = new ArrayList<>();
		list.add(video);
		return list;
	}

	private static VideoResponse createExistsControllerRequest() {
		VideoResponse videoResponse = new VideoResponse(4L, "Curso de QA", "Aprendnedo QA", "http://test.com");
		return videoResponse;
	}

	private static VideoRequest createNewRequest() {
		VideoRequest videoRequest = new VideoRequest("Curso de kambam", "Curso iniciante", "http://test.com");
		return videoRequest;
	}

//	private static Video createVideos() {
//		Video video = new Video(5L, "Curso de Scrum", "Curso iniciante", "http://testewa.com.br");
//
//		return video;
//	}

	private static VideoUpdateRequest updateRequest() {
		VideoUpdateRequest videoRequest = new VideoUpdateRequest("Curso de banco de dados", "http://testesbd.com");
		return videoRequest;
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
