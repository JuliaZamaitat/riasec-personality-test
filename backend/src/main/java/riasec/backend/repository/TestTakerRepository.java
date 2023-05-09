package riasec.backend.repository;

import org.springframework.data.repository.CrudRepository;
import riasec.backend.model.classes.TestTaker;

// This will be AUTO IMPLEMENTED by Spring into a Bean called testTakerRepository
// CRUD refers Create, Read, Update, Delete
public interface TestTakerRepository extends CrudRepository<TestTaker, Integer>  {}
