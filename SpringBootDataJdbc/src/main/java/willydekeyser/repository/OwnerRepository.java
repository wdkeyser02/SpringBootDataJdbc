package willydekeyser.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import willydekeyser.model.Owner;

@Repository
public interface OwnerRepository extends ListCrudRepository<Owner,Integer> {

}
