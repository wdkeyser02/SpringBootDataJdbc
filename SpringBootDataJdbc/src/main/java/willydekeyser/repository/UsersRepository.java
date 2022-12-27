package willydekeyser.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import willydekeyser.model.Users;

@Repository
public interface UsersRepository extends ListCrudRepository<Users, Integer>, PagingAndSortingRepository<Users, Integer> {

}
