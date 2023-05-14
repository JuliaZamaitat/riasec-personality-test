package riasec.backend.controller;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import riasec.backend.model.classes.*;
import riasec.backend.model.enums.Gender;
import riasec.backend.model.enums.PersonalityType;
import riasec.backend.repository.*;

import java.util.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
public class HollandCodeTestAttemptController {

    private final KieContainer kieContainer;

    public HollandCodeTestAttemptController() {
        KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.getKieClasspathContainer();
    }

    @Autowired
    HollandCodeTestQuestionRepository hollandCodeTestQuestionRepository;

    @Autowired
    ProfessionRepository professionRepository;

    @Autowired
    TestTakerRepository testTakerRepository;

    @Autowired
    HollandCodeTestRepository hollandCodeTestRepository;

    @Autowired
    HollandCodeTestAttemptRepository hollandCodeTestAttemptRepository;

    @PostMapping("/testAttempt")
    public ResponseEntity<Map<String, List<?>>> processAnswers(@RequestBody Map<String, Object> requestData) {
        try {

            Map<Long, Boolean> answersJson = (Map<Long, Boolean>) requestData.get("questionAnswer");
            System.out.println(answersJson);
            Map<String, String> user = (Map<String, String>) requestData.get("user");
            //Prepare Data
            Iterable<HollandCodeTestQuestion> questions = hollandCodeTestQuestionRepository.findAll();
            System.out.println("user: " + user);

            // Convert Map<Long, Boolean> to Map<HollandCodeTestQuestion, Boolean>
            Map<HollandCodeTestQuestion, Boolean> questionAnswers = new HashMap<>();
            for (HollandCodeTestQuestion question : questions) {
                Boolean answer = answersJson.get(String.valueOf(question.getId()));
                if (answer != null) {
                    questionAnswers.put(question, answer);
                }
            }

            String firstName = user.get("firstName");
            String lastName = user.get("lastName");
            String gender = user.get("gender");
            String email = user.get("email");

            Gender genderEnum;
            if (gender.equals("Male")) {
                genderEnum = Gender.MALE;
            } else if (gender.equals("Female")) {
                genderEnum = Gender.FEMALE;
            } else if (gender.equals("Non-Binary")) {
                genderEnum = Gender.NONBINARY;
            } else {
                genderEnum = Gender.OTHER;
            }

            //Check if user already exists
            TestTaker testTaker = testTakerRepository.findByEmailAddress(email);
            if (testTaker == null) {
                testTaker = new TestTaker(firstName, lastName, email, genderEnum);
                System.out.println("New user created");
            }
            testTakerRepository.save(testTaker);
            HollandCodeTestAttempt testAttempt = new HollandCodeTestAttempt();
            testAttempt.setTestTaker(testTaker);
            testAttempt.setQuestionAnswers(questionAnswers);

            Optional<HollandCodeTest> hollandCodeTest = hollandCodeTestRepository.findById(Integer.parseInt(String.valueOf(requestData.get("testId"))));
            if (hollandCodeTest.isPresent()) {
                HollandCodeTest hollandCodeTestObject = hollandCodeTest.get();
                testAttempt.setTest(hollandCodeTestObject);
            }



            //Neue Drools-Session erstellen
            KieSession kieSession = createDroolsSession();

            // Inserting Facts into Working Memory
            kieSession.insert(testAttempt);
            Iterable<Profession> allProfessions = professionRepository.findAll();
            for (Profession profession : allProfessions) {
                kieSession.insert(profession);
            }

            //Setting Globals
            List<Profession> exactMatches = new ArrayList<>();
            List<Profession> similarMatches = new ArrayList<>();
            kieSession.setGlobal("version", 2);
            kieSession.setGlobal("exactMatches", exactMatches);
            kieSession.setGlobal("similarMatches", similarMatches);

            //Firing Rules
            kieSession.fireAllRules();
            hollandCodeTestAttemptRepository.save(testAttempt);

            System.out.println("Realistic Score: " + testAttempt.getScore(PersonalityType.REALISTIC));
            System.out.println("Artistic Score: " + testAttempt.getScore(PersonalityType.ARTISTIC));
            System.out.println("Investigative Score: " + testAttempt.getScore(PersonalityType.INVESTIGATIVE));
            System.out.println("Conventional Score: " + testAttempt.getScore(PersonalityType.CONVENTIONAL));
            System.out.println("Social Score: " + testAttempt.getScore(PersonalityType.SOCIAL));
            System.out.println("Enterprising Score: " + testAttempt.getScore(PersonalityType.ENTERPRISING));
            //Disposing Session
            kieSession.dispose();


            //Sending Response to Frontend
            Map<String, List<?>> response = new HashMap<>();
            response.put("hollandCode", testAttempt.getResult());
            response.put("exactProfessions", exactMatches);
            response.put("similarProfessions", similarMatches);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    private KieSession createDroolsSession() {
        return kieContainer.newKieSession("rulesKSession");
    }
}
