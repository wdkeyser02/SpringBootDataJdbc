package willydekeyser.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import willydekeyser.model.Users;

@Repository
public interface UsersRepository extends ListCrudRepository<Users, Integer>, ListPagingAndSortingRepository<Users, Integer> {

	@Query("SELECT * FROM users u join users_authorities ua on u.id = ua.users_id WHERE ua.authorities_id = :id")
	List<Users> findAllUsersByAuthorities(@Param("id") Integer id);
}
