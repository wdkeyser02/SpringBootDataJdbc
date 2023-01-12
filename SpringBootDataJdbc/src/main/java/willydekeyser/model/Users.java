package willydekeyser.model;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
		@JsonIgnore @MappedCollection(idColumn = "users_id", keyColumn = "authorities_id") Set<UsersAuthorities> authorities) {
	
	public void addAuthorities(Authorities authorities) {
		this.authorities.add(new UsersAuthorities(AggregateReference.to(authorities.id())));
	}
	
	public void removeAuthorities(Authorities authorities) {
		this.authorities.remove(new UsersAuthorities(AggregateReference.to(authorities.id())));
	}
	
}
