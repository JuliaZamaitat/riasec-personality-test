package riasec.backend;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import riasec.backend.model.classes.HollandCodeTest;
import riasec.backend.model.classes.HollandCodeTestQuestion;
import riasec.backend.model.enums.PersonalityType;
import riasec.backend.repository.HollandCodeTestAttemptRepository;
import riasec.backend.repository.HollandCodeTestQuestionRepository;
import riasec.backend.repository.HollandCodeTestRepository;
import riasec.backend.repository.TestTakerRepository;
import java.util.*;

@SpringBootApplication
@ComponentScan(basePackages = { "riasec.backend", "riasec.backend.model.classes" })public class RiasecTestBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(RiasecTestBackendApplication.class, args);
	}

}
