package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Owner;
import willydekeyser.model.Todo;
import willydekeyser.model.dto.OwnerDetails;
import willydekeyser.repository.OwnerRepository;
import willydekeyser.repository.TodoRepository;

@RestController
@RequiredArgsConstructor
public class OwnerController {

	private final TodoRepository todoRepository;
	private final OwnerRepository ownerRepository;
	
	@GetMapping("/owner")
	public List<Owner> getOwners() {
		return ownerRepository.findAll();
	}
	
	@GetMapping("/owner/{id}")
	public Owner getOwnerById(@PathVariable("id") Integer id) {
		return ownerRepository.findById(id).get();
	}
	
	@GetMapping("/owner/{id}/details")
	public OwnerDetails getOwnerDetails(@PathVariable("id") Integer id) {
		Owner owner = ownerRepository.findById(id).get();
		List<Todo> todos = todoRepository.findAllByOwner(id);
		return new OwnerDetails(owner, todos);
	}
}
