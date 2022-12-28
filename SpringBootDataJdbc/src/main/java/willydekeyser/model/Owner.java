package willydekeyser.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("Owner")
public record Owner(
		@Id Integer id,
        String fullName,
        String email,
        String username) {

}
