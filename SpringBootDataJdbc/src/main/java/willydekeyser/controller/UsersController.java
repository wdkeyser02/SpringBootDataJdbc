package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Users;
import willydekeyser.model.dto.UsersDetails;
import willydekeyser.service.UsersService;

@RestController
@RequiredArgsConstructor
public class UsersController {

	private final UsersService usersService;
	
	@GetMapping("/users")
	public List<Users> getUsers() {
		return usersService.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public Users getAuthoritiesById(@PathVariable("id") Integer id) {
		return usersService.getUsersById(id);
	}
	
	@GetMapping("/users/{id}/details")
	public UsersDetails getUsersDetails(@PathVariable("id") Integer id) {
		return usersService.getUsersDetails(id);
	}
}
