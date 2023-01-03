package willydekeyser.model;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;

@Table("users")
@Builder
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
		LocalDate birthdate,
		@MappedCollection(idColumn = "users_id") Set<UsersAuthorities> authorities) {

}
