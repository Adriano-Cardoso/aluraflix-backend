package br.com.adriano.aluraflix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

@Api(value = "Video Endpoint", description = "Endpoints para playlist de vídeos", tags = { "Video Endpoint" })
@RestController
@AllArgsConstructor
@RequestMapping("/videos")
public class VideoController {

	private VideoService videoService;

	@ApiOperation(value = "find all vídeos")
	@GetMapping
	public ResponseEntity<List<VideoResponse>> listAllVideos() {
		return ResponseEntity.status(HttpStatus.OK).body(this.videoService.listAllVideos());
	}

	@ApiOperation(value = "find by id vídeos")
	@GetMapping("/{videoId}")
	public ResponseEntity<VideoResponse> findByVideoId(@PathVariable("videoId") Long videoId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.videoService.findByVideoId(videoId));

	}

	@ApiOperation(value = "create new vídeos")
	@PostMapping
	public ResponseEntity<VideoResponse> create(@Valid @RequestBody VideoRequest videoRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.videoService.create(videoRequest));
	}

	@ApiOperation(value = "update vídeos")
	@PatchMapping("/{videoId}")
	public ResponseEntity<VideoResponse> update(@RequestBody @Valid VideoUpdateRequest videoUpdateRequest,
			@PathVariable("videoId") Long videoId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.videoService.update(videoId, videoUpdateRequest));
	}
    
	@ApiOperation(value = "delete vídeos")
	@DeleteMapping("/{videoId}")
	public ResponseEntity<VideoResponse> delete(@Valid @PathVariable("videoId") Long videoId) {
		this.videoService.delete(videoId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
