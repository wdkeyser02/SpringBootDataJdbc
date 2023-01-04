package willydekeyser.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import willydekeyser.model.Authorities;

@Repository
public interface AuthoritiesRepository extends ListCrudRepository<Authorities, Integer> {

	@Query("SELECT a.* FROM authorities a join users_authorities ua on a.id = ua.authorities_id WHERE ua.users_id = :id")
	List<Authorities> findAllAuthoritiesByUsers(@Param("id") Integer id);
}
