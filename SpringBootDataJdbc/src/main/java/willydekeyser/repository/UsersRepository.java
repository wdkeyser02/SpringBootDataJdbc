package willydekeyser.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import willydekeyser.model.Users;

@Repository
public interface UsersRepository extends ListCrudRepository<Users, Integer>, ListPagingAndSortingRepository<Users, Integer> {

	List<Users> findAllByAuthorities(Integer id);
}
