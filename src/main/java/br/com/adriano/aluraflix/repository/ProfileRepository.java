package br.com.adriano.aluraflix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adriano.aluraflix.domain.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
	
	Optional<Profile> findByName(String profile);

}
