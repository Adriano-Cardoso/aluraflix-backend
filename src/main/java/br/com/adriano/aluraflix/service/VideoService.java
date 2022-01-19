package br.com.adriano.aluraflix.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.adriano.aluraflix.domain.Category;
import br.com.adriano.aluraflix.domain.Video;
import br.com.adriano.aluraflix.domain.dto.request.VideoRequest;
import br.com.adriano.aluraflix.domain.dto.request.VideoUpdateRequest;
import br.com.adriano.aluraflix.domain.dto.response.VideoResponse;
import br.com.adriano.aluraflix.repository.VideoRepository;
import br.com.adriano.aluraflix.validations.Message;
import br.com.adriano.aluraflix.validations.OnCreate;
import br.com.adriano.aluraflix.validations.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Validated
@Service("VideoService")
@Slf4j
public class VideoService {

	private VideoRepository videoRepository;

	private CategoryService categoryService;

	@Validated(OnCreate.class)
	public VideoResponse create(@Valid VideoRequest videoRequest) {

		Category category = this.categoryService.findById(videoRequest.getCategoryId());

		this.videoRepository.findByTitle(videoRequest.getTitle()).ifPresent(t -> {
			throw Message.VIDEO_EXIST.asBusinessException();
		});

		Video video = Video.of(videoRequest);

		video.addCategory(category);

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

	public Page<VideoResponse> listAllVideos(int page, int limit, String title) {
		log.info("method=listAllVideos");

		Pageable pageable = PageRequest.of(page, limit);

		log.info("method=findAllVideo page={} limit={} search={}", page, limit);

		return videoRepository.findAllVideos(pageable, title);

	}

	public Page<VideoResponse> free() {
		int limit = 3;
		int page = 0;

		log.info("method=free");

		Pageable pageable = PageRequest.of(page, limit);

		log.info("method=findAllVideoFree limit{}", limit);

		return this.videoRepository.findAllVideoFree(pageable);
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

	public Page<VideoResponse> listByCategory(int page, int limit, Long category) {
		Pageable pageable = PageRequest.of(page, limit);

		log.info("method=listByCategory page={} limit={} categoryId={}", page, limit, category);

		return videoRepository.findByCategory(category, pageable);

	}

}
