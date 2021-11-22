package br.com.adriano.aluraflix.feature;

import br.com.adriano.aluraflix.domain.dto.response.LoginResponse;

public class LoginScenarioFactory {

	public static final LoginResponse LOGIN_RESPONSE = loadLoginResponse();

	private static LoginResponse loadLoginResponse() {
		return new LoginResponse("fkdasofkoadskf0oadsf", "Bearer");
	}
	
	

}
