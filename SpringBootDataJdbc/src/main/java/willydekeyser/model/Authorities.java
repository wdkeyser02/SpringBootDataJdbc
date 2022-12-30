package willydekeyser.model;

import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;

@Table("autorities")
@Builder
public record Authorities(
		Integer id, 
		String authority) {

}
