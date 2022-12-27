package willydekeyser.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import willydekeyser.model.Users;

public interface UsersRepository extends ListCrudRepository<Users, Integer>, PagingAndSortingRepository<Users, Integer> {

}
