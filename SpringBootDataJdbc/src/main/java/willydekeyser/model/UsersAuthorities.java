package willydekeyser.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users_authorities")
public record UsersAuthorities(
		@Column("authorities_id") Integer authorities,
		@Column("users_id") Integer users) {

}
