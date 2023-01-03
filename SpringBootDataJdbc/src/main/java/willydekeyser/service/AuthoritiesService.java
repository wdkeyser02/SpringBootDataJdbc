package willydekeyser.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Authorities;
import willydekeyser.model.Users;
import willydekeyser.model.dto.AuthoritiesDetails;
import willydekeyser.repository.AuthoritiesRepository;
import willydekeyser.repository.UsersRepository;

@Service
@RequiredArgsConstructor
public class AuthoritiesService {
	
	private final AuthoritiesRepository authoritiesRepository;
	private final UsersRepository usersRepository;
	
	public List<Authorities> getAuthorities() {
		return authoritiesRepository.findAll();
	}
	
	public Authorities getAuthoritiesById(Integer id) {
		return authoritiesRepository.findById(id).get();
	}
	
	public AuthoritiesDetails getAuthoritiesDetails(Integer id) {
		Authorities authorities = authoritiesRepository.findById(id).get();
		List<Users> users = usersRepository.findAllById(null);
		return new AuthoritiesDetails(authorities, users);
	}
}
