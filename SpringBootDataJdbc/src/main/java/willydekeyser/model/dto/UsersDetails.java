package willydekeyser.model.dto;

import java.util.List;

import willydekeyser.model.Authorities;
import willydekeyser.model.Users;

public record UsersDetails(
		Users users, 
		List<Authorities> authorities) {

}
