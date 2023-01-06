package willydekeyser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Tutorial;
import willydekeyser.repository.TutorialRepository;

@Service
@RequiredArgsConstructor
public class TutorialService {

	private final TutorialRepository tutorialRepository;
	
	public List<Tutorial> getTutorials() {
		return tutorialRepository.findAll();
	}
	
	public Optional<Tutorial> getTutorialById(Integer id) {
		return tutorialRepository.findById(id);
	}
	
	public Tutorial createTutorial(Tutorial tutorial) {
		return tutorialRepository.save(tutorial);
	}
	
	public List<Tutorial> createListTutorial(List<Tutorial> tutorial) {
		return tutorialRepository.saveAll(tutorial);
	}
	
	public Tutorial updateTutorial(Tutorial tutorial) {
		return tutorialRepository.save(tutorial);
	}
	
	public Tutorial patchTutorial(Tutorial tutorial) {
		return tutorialRepository.save(tutorial);
	}

	public void deleteTutorial(Integer id) {
		tutorialRepository.deleteById(id);
	}
	
	public void deleteAllTutorial() {
		tutorialRepository.deleteAll();
	}

}
