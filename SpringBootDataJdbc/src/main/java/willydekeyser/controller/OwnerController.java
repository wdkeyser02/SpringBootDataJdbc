package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Owner;
import willydekeyser.model.dto.OwnerDetails;
import willydekeyser.service.OwnerService;

@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerController {

	private final OwnerService ownerService;
	
	@GetMapping
	public List<Owner> getOwners() {
		return ownerService.getOwners();
	}
	
	@GetMapping("/{id}")
	public Owner getOwnerById(@PathVariable("id") Integer id) {
		return ownerService.getOwnerById(id);
	}
	
	@GetMapping("/{id}/details")
	public OwnerDetails getOwnerDetails(@PathVariable("id") Integer id) {
		return getOwnerDetails(id);
	}
	
	@PostMapping
	public Owner createOwner(@RequestBody Owner owner) {
		return ownerService.createOwner(owner);
	}
	
	@PostMapping("/all")
	public Owner createListOwner(@RequestBody Owner owner) {
		return ownerService.createOwner(owner);
	}
	
	@PutMapping
	public Owner updateOwner(@RequestBody Owner owner) {
		return ownerService.updateOwner(owner);
	}
	
	@PatchMapping
	public Owner patchOwner(@RequestBody Owner owner) {
		return ownerService.patchOwner(owner);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOwner(@PathVariable("id") Integer id) {
		ownerService.deleteOwner(id);
	}
	
	@DeleteMapping("/all")
	public void deleteAllOwner() {
		ownerService.deleteAllOwner();
	}
}
