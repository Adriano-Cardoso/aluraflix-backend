package br.com.adriano.aluraflix.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.adriano.aluraflix.domain.Profile;
import br.com.adriano.aluraflix.domain.User;
import br.com.adriano.aluraflix.domain.dto.request.UserRequest;
import br.com.adriano.aluraflix.domain.dto.response.UserResponse;

public class UserScenarioFactory {

	public static final Optional<User> USER = loadUser();
	public static final UserRequest USER_REQUEST = loadUserResquert();
	public static final UserResponse USER_RESPONSE = loadUserResponse();

	private static Optional<User> loadUser() {
		return Optional.of(loadRuleType());
	}
	
	 private static UserResponse loadUserResponse() {
		return UserResponse.builder().email("teste@teste.com").username("teste").build();
	}

	private static UserRequest loadUserResquert() {
		return new UserRequest("teste@teste.com", "teste", "12345678");
	}

	private static User loadRuleType() {
	        return new User(1L, "teste", "teste@teste.com", "123456", listProfile());
	    } 
	
	
	private static List<Profile> listProfile() {
		List<Profile> list = new ArrayList<>();
		
		Profile profile = new Profile(1L, "test");
		
		list.add(profile);
		
		return list;
		
	}


}
