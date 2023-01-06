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
import willydekeyser.model.Tutorial;
import willydekeyser.service.TutorialService;

@RestController
@RequestMapping("/tutorial")
@RequiredArgsConstructor
public class TutorialController {

	private final TutorialService tutorialService;
	
	@GetMapping
	public List<Tutorial> getTutorials() {
		return tutorialService.getTutorials();
	}
	
	@GetMapping("/{id}")
	public Tutorial getTutorialById(@PathVariable("id") Integer id) {
		return tutorialService.getTutorialById(id).orElse(null);
	}
	
	@PostMapping
	public Tutorial createTutorial(@RequestBody Tutorial tutorial) {
		return tutorialService.createTutorial(tutorial);
	}
	
	@PostMapping("/all")
	public List<Tutorial> createListTutorial(@RequestBody List<Tutorial> tutorial) {
		return tutorialService.createListTutorial(tutorial);
	}
	
	@PutMapping
	public Tutorial updateTutorial(@RequestBody Tutorial tutorial) {
		return tutorialService.updateTutorial(tutorial);
	}
	
	@PatchMapping
	public Tutorial patchTutorial(@RequestBody Tutorial tutorial) {
		return tutorialService.patchTutorial(tutorial);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTutorial(@PathVariable("id") Integer id) {
		tutorialService.deleteTutorial(id);
	}
	
	@DeleteMapping("/all")
	public void deleteAllTutorial() {
		tutorialService.deleteAllTutorial();
	}
}
