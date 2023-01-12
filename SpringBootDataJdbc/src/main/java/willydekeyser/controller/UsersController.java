package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Users;
import willydekeyser.model.dto.UsersDetails;
import willydekeyser.service.UsersService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

	private final UsersService usersService;
	
	@GetMapping
	public List<Users> getUsers() {
		return usersService.getUsers();
	}
	
	@GetMapping("/{id}")
	public Users getAuthoritiesById(@PathVariable("id") Integer id) {
		return usersService.getUsersById(id);
	}
	
	@GetMapping("/{id}/details")
	public UsersDetails getUsersDetails(@PathVariable("id") Integer id) {
		return usersService.getUsersDetails(id);
	}
	
	@PostMapping
	public Users createUsers(@RequestBody Users users) {
		return usersService.createUsers(users);
	}
	
	@PutMapping
	public Users updateUsers(@RequestBody Users users) {
		return usersService.updateUsers(users);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsers(@PathVariable("id") Integer id) {
		usersService.deleteUsers(id);
	}
}
