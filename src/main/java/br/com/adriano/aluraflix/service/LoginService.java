package br.com.adriano.aluraflix.service;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.adriano.aluraflix.configuration.security.JwtTokenProvider;
import br.com.adriano.aluraflix.domain.dto.request.LoginRequest;
import br.com.adriano.aluraflix.domain.dto.response.LoginResponse;

@Service("LoginService")
@Validated
public class LoginService {
	
    @Autowired
	private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public LoginResponse auth(@Valid LoginRequest loginRequest) {
     
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));

        String token=jwtTokenProvider.createToken(loginRequest.getEmail(),authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

        return new LoginResponse(token,"Bearer");
    }

}
