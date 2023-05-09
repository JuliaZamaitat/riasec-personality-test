package riasec.backend.repository;

import org.springframework.data.repository.CrudRepository;
import riasec.backend.model.classes.HollandCodeTestAttempt;

// This will be AUTO IMPLEMENTED by Spring into a Bean called hollandCodeTestAttemptRepository
// CRUD refers Create, Read, Update, Delete
public interface HollandCodeTestAttemptRepository extends CrudRepository<HollandCodeTestAttempt, Integer> { }
