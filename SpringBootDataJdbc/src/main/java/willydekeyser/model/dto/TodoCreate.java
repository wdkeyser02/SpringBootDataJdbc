package willydekeyser.model.dto;

public record TodoCreate(
		Integer ownerId,
	    String title,
	    String content) {

}
