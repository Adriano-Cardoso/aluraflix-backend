package br.com.adriano.aluraflix.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.adriano.aluraflix.domain.Video;
import br.com.adriano.aluraflix.domain.dto.request.VideoRequest;
import br.com.adriano.aluraflix.domain.dto.request.VideoUpdateRequest;
import br.com.adriano.aluraflix.domain.dto.response.VideoResponse;
import br.com.adriano.aluraflix.repository.VideoRepository;
import br.com.adriano.aluraflix.validations.OnCreate;
import br.com.adriano.aluraflix.validations.OnUpdate;
import br.com.adriano.aluraflix.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Validated
@Service("VideoService")
@Slf4j
public class VideoService {

	private VideoRepository videoRepository;

	@Validated(OnCreate.class)
	public VideoResponse create(VideoRequest videoRequest) {
		this.videoRepository.findByTitle(videoRequest.getTitle()).ifPresent(t -> {
			throw Message.VIDEO_EXIST.asBusinessException();
		});

		Video video = Video.of(videoRequest);

		this.videoRepository.save(video);

		log.info("method=create videoId={} title={} description={} url={}", video.getVideoId(), video.getTitle(),
				video.getDescription(), video.getUrl());

		return video.toDto();
	}

	@Validated(OnUpdate.class)
	@Transactional
	public VideoResponse update(Long videoId, VideoUpdateRequest videoUpdateRequest) {
		Video video = this.videoRepository.findById(videoId).orElseThrow(Message.NOT_FOUND_VIDEO::asBusinessException);

		video.update(videoUpdateRequest);

		log.info("method=update videoId={} description={} url={}", videoId, video.getDescription(), video.getUrl());
		return video.toDto();

	}

	public List<VideoResponse> listAllVideos() {
		log.info("method=listAllVideos");

		return this.videoRepository.findAllVideos();
	}

	public VideoResponse findByVideoId(Long videoId) {
		Video video = this.videoRepository.findById(videoId).orElseThrow(Message.NOT_FOUND_VIDEO::asBusinessException);

		log.info("method=findByVideoId videoId={}", videoId);

		return video.toDto();

	}

	public void delete(Long videoId) {
		Video video = this.videoRepository.findById(videoId).orElseThrow(Message.NOT_FOUND_VIDEO::asBusinessException);

		log.info("method=delete videoId={}", videoId);

		this.videoRepository.delete(video);

	}

}
