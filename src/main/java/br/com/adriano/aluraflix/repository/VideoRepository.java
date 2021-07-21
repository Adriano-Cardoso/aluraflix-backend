package br.com.adriano.aluraflix.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.adriano.aluraflix.domain.Video;
import br.com.adriano.aluraflix.domain.dto.response.VideoResponse;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{
	
	@Query("select new br.com.adriano.aluraflix.domain.dto.response.VideoResponse(v.videoId, v.title, v.description, v.url) From Video v")
	List<VideoResponse> findAllVideos();
	
	@Query("select new br.com.adriano.aluraflix.domain.dto.response.VideoResponse(v.videoId, v.title, v.description, v.url) From Video v where v.title=:title")
	Optional<VideoResponse> findByTitle(@Param("title") String title);

}
