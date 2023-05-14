package riasec.backend;

import com.github.javafaker.Faker;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import riasec.backend.model.classes.HollandCodeTest;
import riasec.backend.model.classes.HollandCodeTestAttempt;
import riasec.backend.model.classes.HollandCodeTestQuestion;
import riasec.backend.model.classes.TestTaker;
import riasec.backend.model.enums.Gender;
import riasec.backend.model.enums.PersonalityType;
import riasec.backend.repository.HollandCodeTestAttemptRepository;
import riasec.backend.repository.HollandCodeTestQuestionRepository;
import riasec.backend.repository.HollandCodeTestRepository;
import riasec.backend.repository.TestTakerRepository;

import java.lang.reflect.Array;
import java.util.*;

@SpringBootApplication
@ComponentScan(basePackages = { "riasec.backend", "riasec.backend.model.classes" })public class RiasecTestBackendApplication {
	@Autowired
	TestTakerRepository testTakerRepository;
	@Autowired
	HollandCodeTestQuestionRepository hollandCodeTestQuestionRepository;
	@Autowired
	HollandCodeTestRepository hollandCodeTestRepository;
	@Autowired
	HollandCodeTestAttemptRepository hollandCodeTestAttemptRepository;

	public static void main(String[] args) {
		SpringApplication.run(RiasecTestBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			int max = 1;
			Faker faker = new Faker(new Locale("en-US"));
			HashMap<HollandCodeTestQuestion, Boolean> questionAnswers = new HashMap<>();

			for(int i = 0; i < max; i++) {
				TestTaker testTaker = new TestTaker(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), Gender.FEMALE);
				testTakerRepository.save(testTaker);

				List<HollandCodeTestQuestion> questions = new ArrayList<>();
				HollandCodeTestQuestion question1 = new HollandCodeTestQuestion("Do you like working with your hands?", PersonalityType.REALISTIC);
				HollandCodeTestQuestion question2 = new HollandCodeTestQuestion("Are you creative?", PersonalityType.ARTISTIC);
				HollandCodeTestQuestion question3 = new HollandCodeTestQuestion("Are you investigative?", PersonalityType.INVESTIGATIVE);
				HollandCodeTestQuestion question4 = new HollandCodeTestQuestion("Are you conventional?", PersonalityType.CONVENTIONAL);
				HollandCodeTestQuestion question5 = new HollandCodeTestQuestion("Are you realistic?", PersonalityType.REALISTIC);


				questions.add(question1);
				questions.add(question2);
				questions.add(question3);
				questions.add(question4);
				questions.add(question5);



				questionAnswers.put(question1, true);
				questionAnswers.put(question2, false);
				hollandCodeTestQuestionRepository.save(question1);
				hollandCodeTestQuestionRepository.save(question2);
				hollandCodeTestQuestionRepository.save(question3);
				hollandCodeTestQuestionRepository.save(question4);
				hollandCodeTestQuestionRepository.save(question5);


				HollandCodeTest test = new HollandCodeTest("Holland Code Test", "This is a personality test based on the RIASEC model. This is a first basic implementation.", 1, questions);
				hollandCodeTestRepository.save(test);

				HollandCodeTest test2 = new HollandCodeTest("Holland Code Test Advanced", "This is a personality test based on the RIASEC model. Here we have a more advanced implementation.", 2, questions);
				hollandCodeTestRepository.save(test2);

				HollandCodeTest test3 = new HollandCodeTest("Holland Code Test More Advanced Than Before", "This is a personality test based on the RIASEC model. Here we have a even more advanced implementation than before with loooots of questions. Try your best!.", 3, questions);
				hollandCodeTestRepository.save(test3);

				ArrayList<String> resultList = new ArrayList<>();
				resultList.add(0, "BAI");
				resultList.add(1, "RIA");
				HollandCodeTestAttempt testAttempt = new HollandCodeTestAttempt(testTaker, resultList, test, 20, 10, 15, 5, 5, 3,questionAnswers);
				hollandCodeTestAttemptRepository.save(testAttempt);


			}
		};
	}

}
