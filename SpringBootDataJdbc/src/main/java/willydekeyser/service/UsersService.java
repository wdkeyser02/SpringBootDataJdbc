package willydekeyser.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Authorities;
import willydekeyser.model.Users;
import willydekeyser.model.dto.UsersDetails;
import willydekeyser.repository.AuthoritiesRepository;
import willydekeyser.repository.UsersRepository;

@Service
@RequiredArgsConstructor
public class UsersService {

	private final UsersRepository usersRepository;
	private final AuthoritiesRepository authoritiesRepository;
	
	public List<Users> getUsers() {
		return usersRepository.findAll();
	}
	
	public Users getUsersById(@PathVariable("id") Integer id) {
		return usersRepository.findById(id).get();
	}
	
	public UsersDetails getUsersDetails(@PathVariable("id") Integer id) {
		Users users = usersRepository.findById(id).get();
		List<Authorities> authorities = authoritiesRepository.findAllById(null);
		return new UsersDetails(users, authorities);
	}
}
