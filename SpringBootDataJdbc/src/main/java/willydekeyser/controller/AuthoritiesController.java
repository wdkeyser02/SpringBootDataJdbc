package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Authorities;
import willydekeyser.model.dto.AuthoritiesDetails;
import willydekeyser.service.AuthoritiesService;

@RestController
@RequiredArgsConstructor
public class AuthoritiesController {

	private final AuthoritiesService authoritiesService;
	
	@GetMapping("/authorities")
	public List<Authorities> getAuthorities() {
		return authoritiesService.getAuthorities();
	}
	
	@GetMapping("/authorities/{id}")
	public Authorities getAuthoritiesById(@PathVariable("id") Integer id) {
		return authoritiesService.getAuthoritiesById(id);
	}
	
	@GetMapping("/authorities/{id}/details")
	public AuthoritiesDetails getAuthoritiesDetails(@PathVariable("id") Integer id) {
		return authoritiesService.getAuthoritiesDetails(id);
	}
	
}
