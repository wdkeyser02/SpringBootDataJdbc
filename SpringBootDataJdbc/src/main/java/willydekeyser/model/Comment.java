package willydekeyser.model;

import java.time.LocalDateTime;

import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;

@Table("Comment")
@Builder
public record Comment(
		String name,
        String content,
        LocalDateTime publishedOn,
        LocalDateTime updatedOn) {

}
