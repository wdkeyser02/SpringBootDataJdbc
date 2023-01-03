package willydekeyser.model;

import org.springframework.data.relational.core.mapping.Table;

@Table("users_authorities")
public record UsersAuthorities(
		Integer authorities_id) {

}
