package willydekeyser.service;

import java.util.List;

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
	
	public Tutorial getTutorialById(Integer id) {
		return tutorialRepository.findById(id).get();
	}
	
	public Tutorial createTutorial(Tutorial owner) {
		return tutorialRepository.save(owner);
	}
	
	public Tutorial updateTutorial(Tutorial owner) {
		return tutorialRepository.save(owner);
	}

	public void deleteTutorial(Integer id) {
		tutorialRepository.deleteById(id);
	}

}
