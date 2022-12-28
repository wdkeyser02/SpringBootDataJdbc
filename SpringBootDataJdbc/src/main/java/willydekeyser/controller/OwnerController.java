package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Owner;
import willydekeyser.repository.OwnerRepository;

@RestController
@RequiredArgsConstructor
public class OwnerController {

	private final OwnerRepository ownerRepository;
	
	@GetMapping("/owner")
	public List<Owner> getOwners() {
		return ownerRepository.findAll();
	}
}
