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
import willydekeyser.model.Tutorial;
import willydekeyser.service.TutorialService;

@RestController
@RequiredArgsConstructor
public class TutorialController {

	private final TutorialService tutorialService;
	
	@GetMapping("/tutorial")
	public List<Tutorial> getTutorials() {
		return tutorialService.getTutorials();
	}
	
	@GetMapping("/tutorial/{id}")
	public Tutorial getTutorialById(@PathVariable("id") Integer id) {
		return tutorialService.getTutorialById(id);
	}
	
	@PostMapping("/tutorial")
	public Tutorial createTutorial(@RequestBody Tutorial tutorial) {
		return tutorialService.createTutorial(tutorial);
	}
	
	@PutMapping("/tutorial")
	public Tutorial updateTutorial(@RequestBody Tutorial tutorial) {
		return tutorialService.updateTutorial(tutorial);
	}
	
	@DeleteMapping("/tutorial/{id}")
	public void deleteTutorial(@PathVariable("id") Integer id) {
		tutorialService.deleteTutorial(id);
	}
}
