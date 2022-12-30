package willydekeyser.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Owner;
import willydekeyser.model.Todo;
import willydekeyser.repository.OwnerRepository;

@RestController
@RequiredArgsConstructor
public class OwnerController {

	private final OwnerRepository ownerRepository;
	
	@GetMapping("/owner")
	public List<Owner> getOwners() {
		return ownerRepository.findAll();
	}
	
	@GetMapping("/owner/{id}")
	public Owner getOwnerById(@PathVariable("id") Integer id) {
		Owner owner = ownerRepository.findById(id).get();
		owner.addTodo(new Todo(null, "Testen", "My first test", LocalDateTime.now(), null, AggregateReference.to(id), null));
		ownerRepository.save(owner);
		return ownerRepository.findById(id).get();
	}
	
}
