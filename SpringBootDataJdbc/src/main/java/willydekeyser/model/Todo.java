package willydekeyser.model;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

@Table("Todo")
public record Todo(
		@Id Integer id,
	    String title,
	    String content,
	    LocalDateTime publishedOn,
	    LocalDateTime updatedOn,
	    AggregateReference<Owner, Integer> owner,
	    Set<Comment> comments) {

}
