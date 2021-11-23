package br.com.adriano.aluraflix.validations;

import org.springframework.http.HttpStatus;

import br.com.adriano.aluraflix.exception.BusinessException;

public enum Message {

	NOT_FOUND_VIDEO("O video nao foi encontrado", HttpStatus.NOT_FOUND),
	VIDEO_EXIST("O video ja existe", HttpStatus.BAD_REQUEST),
	CATEGORY_EXIST("A categoria ja existe", HttpStatus.BAD_REQUEST),
	NOT_FOUND_ID("O id nao existe", HttpStatus.NOT_FOUND),
	CATEGORY_TITLE_EXIST("O titulo da categoria nao existe", HttpStatus.NOT_FOUND),
	USER_NOT_FOUND("O Usuario nao foi encontrado"), 
	NAME_PROFILE_NOT_FOUND("E-mail ou senha nao encontrados"),
	TOKEN_ERROR("Token invalido"), 
	NOT_FOT_USER_PERMISSION("O Usuario nao tem permissao", HttpStatus.NOT_FOUND),
	IS_PRESENT_USER("Usuario presente ", HttpStatus.BAD_REQUEST), 
	NOT_FOUND_CATEGORY("A categoria nao foi encontrada ", HttpStatus.NOT_FOUND);

	private String value;
	private String description;
	private HttpStatus statusCode;

	private Message(String value, HttpStatus statusCode) {
		this.value = value;
		this.statusCode = statusCode;
	}

	private Message(String value, String description, HttpStatus statusCode) {
		this.value = value;
		this.description = description;
		this.statusCode = statusCode;
	}

	private Message(String value) {
		this.value = value;
	}

	public String getMessage() {
		return this.value;
	}

	public HttpStatus getStatus() {
		return this.statusCode;
	}

	public String getDescription() {
		return description;
	}

	public BusinessException asBusinessException() {
		return BusinessException.builder().httpStatusCode(this.getStatus())
				.code(String.valueOf(this.getStatus().value())).message(this.getMessage())
				.description(this.getDescription()).build();
	}
}
