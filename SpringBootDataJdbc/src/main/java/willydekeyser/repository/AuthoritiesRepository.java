package willydekeyser.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import willydekeyser.model.Authorities;

@Repository
public interface AuthoritiesRepository extends ListCrudRepository<Authorities, Integer> {

}
