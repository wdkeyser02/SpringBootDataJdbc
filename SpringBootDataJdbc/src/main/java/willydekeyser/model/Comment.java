package willydekeyser.model;

import java.time.LocalDateTime;

import org.springframework.data.relational.core.mapping.Table;

@Table("Comment")
public record Comment(
		String name,
        String content,
        LocalDateTime publishedOn,
        LocalDateTime updatedOn) {

}
