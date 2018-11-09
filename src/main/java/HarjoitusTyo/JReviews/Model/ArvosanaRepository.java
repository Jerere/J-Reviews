package HarjoitusTyo.JReviews.Model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArvosanaRepository extends CrudRepository<Arvosana, Long> {

	List<Arvosana> findByArvosana (String arvosana);
}
