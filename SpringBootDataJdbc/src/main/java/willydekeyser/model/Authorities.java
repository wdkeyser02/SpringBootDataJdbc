package willydekeyser.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;

@Table("authorities")
@Builder
public record Authorities(
		@Id Integer id, 
		String authority,
		@MappedCollection(idColumn = "authorities_id", keyColumn = "users_id") Set<UsersAuthorities> users ) {

}
