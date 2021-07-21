package br.com.adriano.aluraflix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adriano.aluraflix.domain.dto.request.VideoRequest;
import br.com.adriano.aluraflix.domain.dto.request.VideoUpdateRequest;
import br.com.adriano.aluraflix.domain.dto.response.VideoResponse;
import br.com.adriano.aluraflix.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(value = "Video Endpoint", description = "Description for video", tags = { "Video Endpoint" })
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/videos")
public class VideoController {

	private VideoService videoService;

	@ApiOperation(value = "find all video")
	@GetMapping
	public ResponseEntity<List<VideoResponse>> listAllVideos() {
		return ResponseEntity.status(HttpStatus.OK).body(this.videoService.listAllVideos());
	}

	@ApiOperation(value = "find by id video")
	@GetMapping("/{videoId}")
	public ResponseEntity<VideoResponse> findByVideoId(@PathVariable("videoId") Long videoId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.videoService.findByVideoId(videoId));

	}

	@ApiOperation(value = "create new video")
	@PostMapping
	public ResponseEntity<VideoResponse> cadastrarCliente(@Valid @RequestBody VideoRequest videoRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.videoService.create(videoRequest));
	}

	@ApiOperation(value = "update video")
	@PutMapping("/{videoId}")
	public ResponseEntity<VideoResponse> update(@RequestBody @Valid VideoUpdateRequest videoUpdateRequest,
			@PathVariable("videoId") Long videoId) {
		return ResponseEntity.ok(this.videoService.update(videoId, videoUpdateRequest));
	}
    
	@ApiOperation(value = "delete video")
	@DeleteMapping("/{videoId}")
	public ResponseEntity<VideoResponse> delete(@Valid @PathVariable("videoId") Long videoId) {
		this.videoService.delete(videoId);
		return ResponseEntity.ok().build();
	}

}
