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
import willydekeyser.model.Authorities;
import willydekeyser.model.dto.AuthoritiesDetails;
import willydekeyser.service.AuthoritiesService;

@RestController
@RequestMapping("/authorities")
@RequiredArgsConstructor
public class AuthoritiesController {

	private final AuthoritiesService authoritiesService;
	
	@GetMapping
	public List<Authorities> getAuthorities() {
		return authoritiesService.getAuthorities();
	}
	
	@GetMapping("/{id}")
	public Authorities getAuthoritiesById(@PathVariable("id") Integer id) {
		return authoritiesService.getAuthoritiesById(id);
	}
	
	@GetMapping("/{id}/details")
	public AuthoritiesDetails getAuthoritiesDetails(@PathVariable("id") Integer id) {
		return authoritiesService.getAuthoritiesDetails(id);
	}
	
	@PostMapping
	public Authorities createAuthorities(@RequestBody Authorities authorities) {
		return authoritiesService.createAuthorities(authorities);
	}
	
	@PutMapping
	public Authorities updateAuthorities(@RequestBody Authorities authorities) {
		return authoritiesService.createAuthorities(authorities);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAuthorities(@PathVariable("id") Integer id) {
		authoritiesService.deleteAuthorities(id);
	}
	
}
