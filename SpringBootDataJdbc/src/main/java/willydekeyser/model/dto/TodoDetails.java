package willydekeyser.model.dto;

import willydekeyser.model.Owner;
import willydekeyser.model.Todo;

public record TodoDetails(
		Todo tod, 
		Owner owner) {

}
