package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Users;
import willydekeyser.service.UsersService;

@RestController
@RequiredArgsConstructor
public class UsersController {

	private final UsersService usersService;
	
	@GetMapping("/users")
	public List<Users> getUsers() {
		return usersService.getUsers();
	}
	
}
