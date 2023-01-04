package willydekeyser.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import willydekeyser.model.Todo;

@Repository
public interface TodoRepository extends  ListCrudRepository<Todo, Integer>{

	List<Todo> findAllByOwner(Integer id);
	
}
