package willydekeyser.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Owner;
import willydekeyser.model.Todo;
import willydekeyser.model.dto.OwnerDetails;
import willydekeyser.repository.OwnerRepository;
import willydekeyser.repository.TodoRepository;

@Service
@RequiredArgsConstructor
public class OwnerService {

	private final TodoRepository todoRepository;
	private final OwnerRepository ownerRepository;
	
	
	public List<Owner> getOwners() {
		return ownerRepository.findAll();
	}
	
	public Owner getOwnerById(@PathVariable("id") Integer id) {
		return ownerRepository.findById(id).get();
	}
	
	public OwnerDetails getOwnerDetails(@PathVariable("id") Integer id) {
		Owner owner = ownerRepository.findById(id).get();
		List<Todo> todos = todoRepository.findAllByOwner(id);
		return new OwnerDetails(owner, todos);
	}

	public Owner createOwner(Owner owner) {
		return ownerRepository.save(owner);
	}
	
	public Owner updateOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	public void deleteOwner(Integer id) {
		ownerRepository.deleteById(id);
	}
}
