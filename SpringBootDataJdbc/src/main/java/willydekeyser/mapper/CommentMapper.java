package willydekeyser.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import willydekeyser.model.Comment;
import willydekeyser.model.dto.CommentUpdate;

@Component
public class CommentMapper {
	
	public Comment CommentUpdate(CommentUpdate comment) {
		return Comment.builder()
			.name(comment.name())
			.content(comment.content())
			.publishedOn(null)
			.updatedOn(LocalDateTime.now())
			.build();
	}

	
}
