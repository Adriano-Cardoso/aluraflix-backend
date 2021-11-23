package br.com.adriano.aluraflix.feature;

import java.util.Optional;

import br.com.adriano.aluraflix.domain.Profile;

public class ProfileScenarioFactory {

	public static final Object PROFILE = loadProfile();
	public static final Optional<Profile> PROFILE_OPTIONAL = loadProfileOptional();

	private static Profile loadProfile() {
		return new Profile(1L, "test");
	}

	private static Optional<Profile> loadProfileOptional() {
		return Optional.of(loadProfile());
	}

}
