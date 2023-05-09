package riasec.backend.repository;

import org.springframework.data.repository.CrudRepository;
import riasec.backend.model.classes.HollandCodeTest;

// This will be AUTO IMPLEMENTED by Spring into a Bean called hollandCodeTestRepository
// CRUD refers Create, Read, Update, Delete
public interface HollandCodeTestRepository extends CrudRepository<HollandCodeTest, Integer> { }
