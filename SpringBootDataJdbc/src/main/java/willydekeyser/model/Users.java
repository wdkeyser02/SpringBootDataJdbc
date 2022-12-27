package willydekeyser.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public record Users(
		@Id Integer id,
		String username,
		String password,
		Boolean accountNonExpired,
		Boolean accountNonLocked,
		Boolean credentialsNonExpired,
		Boolean enabled,
		String firstName,
		String lastName,
		String emailAddress,
		LocalDate birthdate) {

}
