package willydekeyser.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import willydekeyser.model.Users;

@Repository
public interface UsersRepository extends ListCrudRepository<Users, Integer>, ListPagingAndSortingRepository<Users, Integer> {

}
