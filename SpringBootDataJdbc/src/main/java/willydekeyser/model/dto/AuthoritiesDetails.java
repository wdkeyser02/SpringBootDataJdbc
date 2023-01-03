package willydekeyser.model.dto;

import java.util.List;

import willydekeyser.model.Authorities;
import willydekeyser.model.Users;

public record AuthoritiesDetails(
		Authorities authorities, 
		List<Users> users) {

}
