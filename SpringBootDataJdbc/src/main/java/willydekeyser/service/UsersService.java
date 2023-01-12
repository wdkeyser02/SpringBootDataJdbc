package willydekeyser.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	
	public Users getUsersById(Integer id) {
		return usersRepository.findById(id).get();
	}
	
	public UsersDetails getUsersDetails(Integer id) {
		Users users = usersRepository.findById(id).get();
		List<Authorities> authorities = authoritiesRepository.findAllAuthoritiesByUsers(id);
		return new UsersDetails(users, authorities);
	}
	
	public Users createUsers(Users users) {
		return usersRepository.save(users);
	}
	
	public Users updateUsers(Users users) {
		return usersRepository.save(users);
	}
	
	public void deleteUsers(Integer id) {
		usersRepository.deleteById(id);
	}
}
