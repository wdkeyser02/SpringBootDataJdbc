package willydekeyser.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;

@Table("Tutorial")
@Builder
public record Tutorial(
		@Id Integer id,
        String title) {

}
