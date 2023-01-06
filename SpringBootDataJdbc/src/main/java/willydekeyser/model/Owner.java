package willydekeyser.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;

@Table("Owner")
@Builder
public record Owner(
		@Id Integer id,
        String fullName,
        String email,
        String username,
        @JsonIgnore Address address) {


}
