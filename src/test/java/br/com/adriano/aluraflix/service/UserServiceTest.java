package br.com.adriano.aluraflix.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.adriano.aluraflix.domain.dto.response.UserResponse;
import br.com.adriano.aluraflix.exception.BusinessException;
import br.com.adriano.aluraflix.feature.ProfileScenarioFactory;
import br.com.adriano.aluraflix.feature.UserScenarioFactory;
import br.com.adriano.aluraflix.repository.ProfileRepository;
import br.com.adriano.aluraflix.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@Mock
	private ProfileRepository profileRepository;

	@Test
	@DisplayName("procurar usuario por email")
	void loadUserByName_WhenUsernameIsValid_ExpectedOk() {
		when(this.userRepository.findByEmail(anyString())).thenReturn(UserScenarioFactory.USER);

		UserDetails loadUserByUsername = userService.loadUserByUsername("teste@email.com");

		assertNotNull(loadUserByUsername);

		verify(userRepository).findByEmail(anyString());

	}

	@Test
	@DisplayName("Procurar usuario pelo email mas nao existe")
	public void loadUserByUsername_WhenUsernameIsInvalid_ExpectedOk() {

		when(userRepository.findByEmail(anyString())).thenThrow(BusinessException.class);

		assertThrows(BusinessException.class, () -> userService.loadUserByUsername("teste"));
	}
	
    @Test
    @DisplayName("Criar usuario")
    public void save_WhenEmailIsValid_ExpectedCreate() {

        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());

        when(profileRepository.findByName(any())).thenReturn(ProfileScenarioFactory.PROFILE_OPTIONAL);

        UserResponse save = userService.save(UserScenarioFactory.USER_REQUEST);

        assertNotNull(save);

        verify(userRepository).save(any());
    }

    @Test
    @DisplayName("Criar usuario, mas nao existe o perfil")
    public void save_WhenProfileIsInvalid_ExpectedBusiness() {

        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());

        when(profileRepository.findByName(any())).thenThrow(BusinessException.class);

        assertThrows(BusinessException.class, () -> userService.save(UserScenarioFactory.USER_REQUEST));

    }

    @Test
    @DisplayName("Criar usuario mas ja existe no banco")
    public void save_WhenEmailIsInvalid_ExpectedCreate() {

        when(userRepository.findByEmail(anyString())).thenReturn(UserScenarioFactory.USER);

        assertThrows(BusinessException.class, () -> userService.save(UserScenarioFactory.USER_REQUEST));
    }

}
