package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Owner;
import willydekeyser.model.dto.OwnerDetails;
import willydekeyser.service.OwnerService;

@RestController
@RequiredArgsConstructor
public class OwnerController {

	private final OwnerService ownerService;
	
	@GetMapping("/owner")
	public List<Owner> getOwners() {
		return ownerService.getOwners();
	}
	
	@GetMapping("/owner/{id}")
	public Owner getOwnerById(@PathVariable("id") Integer id) {
		return ownerService.getOwnerById(id);
	}
	
	@GetMapping("/owner/{id}/details")
	public OwnerDetails getOwnerDetails(@PathVariable("id") Integer id) {
		return getOwnerDetails(id);
	}
	
	@PostMapping("/owner")
	public Owner createOwner(@RequestBody Owner owner) {
		Owner newOwner = ownerService.createOwner(owner);
		return newOwner;
	}
	
	@PutMapping("/owner")
	public Owner updateOwner(@RequestBody Owner owner) {
		Owner newOwner = ownerService.updateOwner(owner);
		return newOwner;
	}
	
	@DeleteMapping("/owner/{id}")
	public void deleteOwner(@PathVariable("id") Integer id) {
		ownerService.deleteOwner(id);
	}
	
}
