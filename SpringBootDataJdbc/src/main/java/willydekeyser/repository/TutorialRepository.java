package willydekeyser.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import willydekeyser.model.Tutorial;

@Repository
public interface TutorialRepository extends ListCrudRepository<Tutorial,Integer> {

}
