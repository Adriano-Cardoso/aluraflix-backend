package br.com.adriano.aluraflix.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.adriano.aluraflix.repository.UserRepository;
import br.com.adriano.aluraflix.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Validated
@Slf4j
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	    log.info("method=loadUserByUsername username={}",username);
		return this.userRepository.findByEmail(username)
				.orElseThrow(() -> Message.NAME_PROFILE_NOT_FOUND.asBusinessException());

	}

}
