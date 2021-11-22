package br.com.adriano.aluraflix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adriano.aluraflix.domain.dto.request.LoginRequest;
import br.com.adriano.aluraflix.domain.dto.response.LoginResponse;
import br.com.adriano.aluraflix.service.LoginService;
import lombok.AllArgsConstructor;


@RequestMapping("/auth")
@AllArgsConstructor
@RestController
public class LoginController {

	
	private LoginService loginService;
	
	@PostMapping
	public ResponseEntity<LoginResponse> auth(@RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(loginService.auth(loginRequest));
	}

}
