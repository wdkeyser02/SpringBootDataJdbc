package willydekeyser.model.dto;

import java.util.Set;

import willydekeyser.model.Comment;

public record TodoUpdate(
		Integer id,
		Integer ownerId,
	    String title,
	    String content,
	    Set<Comment> comments) {

}
