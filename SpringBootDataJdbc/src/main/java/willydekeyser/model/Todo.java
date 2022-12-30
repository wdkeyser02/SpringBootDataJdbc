package willydekeyser.model;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;

@Table("Todo")
@Builder
public record Todo(
		@Id Integer id,
	    String title,
	    String content,
	    LocalDateTime publishedOn,
	    LocalDateTime updatedOn,
	    Set<Comment> comments) {

	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	public void removeComment(Comment comment) {
		this.comments.remove(comment);
	}
	
}
