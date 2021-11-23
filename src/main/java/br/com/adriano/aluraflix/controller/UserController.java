package br.com.adriano.aluraflix.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adriano.aluraflix.domain.dto.request.UserRequest;
import br.com.adriano.aluraflix.domain.dto.response.UserResponse;
import br.com.adriano.aluraflix.service.UserService;
import lombok.AllArgsConstructor;

@RequestMapping("/users")
@RestController
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@PostMapping
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userRequest));
	}
}
