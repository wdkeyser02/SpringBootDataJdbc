package willydekeyser.model;

import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;

@Table("Address")
@Builder
public record Address(
		String addressLine) {

}
