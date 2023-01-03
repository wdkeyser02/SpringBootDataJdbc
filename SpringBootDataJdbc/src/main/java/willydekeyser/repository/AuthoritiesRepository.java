package willydekeyser.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import willydekeyser.model.Authorities;

@Repository
public interface AuthoritiesRepository extends ListCrudRepository<Authorities, Integer> {

	List<Authorities> findAllByUsers(Integer id);
}
