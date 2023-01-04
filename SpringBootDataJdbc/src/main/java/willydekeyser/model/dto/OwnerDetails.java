package willydekeyser.model.dto;

import java.util.List;

import willydekeyser.model.Owner;
import willydekeyser.model.Todo;

public record OwnerDetails(
		Owner owner, 
		List<Todo> todos) {

}
