package br.com.adriano.aluraflix.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.adriano.aluraflix.domain.Profile;
import br.com.adriano.aluraflix.domain.User;
import br.com.adriano.aluraflix.domain.dto.request.UserRequest;
import br.com.adriano.aluraflix.domain.dto.response.UsuarioResponse;
import br.com.adriano.aluraflix.repository.UserRepository;
import br.com.adriano.aluraflix.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Validated
@Slf4j
@AllArgsConstructor
public class UserService implements UserDetailsService {
	
	UserRepository userRepository;
    ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("method=loadUserByUsername username={}",username);
        return userRepository.findByEmail(username)
                .orElseThrow(Message.NOT_FOT_USER_PERMISSION::asBusinessException);
    }

    public UsuarioResponse save(@Valid UserRequest userRequest) {
     
        userRepository.findByEmail(userRequest.getEmail()).ifPresent(p -> {
            throw Message.IS_PRESENT_USER.asBusinessException();
        });
        
        Profile profile = profileRepository.findByName("USER").orElseThrow(Message.NAME_PROFILE_NOT_FOUND::asBusinessException);

        List<Profile> listProfile = new ArrayList<>();
        
        listProfile.add(profile);
        
        User user = User.builder().email(userRequest.getEmail())
                .password(new BCryptPasswordEncoder().encode(userRequest.getPassword())).name(userRequest.getUsername())
                .build();

        
        user.setPerfis(listProfile);

        userRepository.save(user);
        
        log.info("method=save username={} email={}", userRequest.getUsername(),userRequest.getEmail());

        return user.toDto();
    }


}
