package riasec.backend.repository;

import org.springframework.data.repository.CrudRepository;
import riasec.backend.model.classes.Profession;

// This will be AUTO IMPLEMENTED by Spring into a Bean called testTakerRepository
// CRUD refers Create, Read, Update, Delete
public interface ProfessionInterface extends CrudRepository<Profession, Integer> {}
