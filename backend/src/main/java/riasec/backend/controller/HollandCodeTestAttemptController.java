package riasec.backend.controller;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import riasec.backend.model.classes.HollandCodeTestAttempt;
import riasec.backend.model.classes.HollandCodeTestQuestion;
import riasec.backend.model.classes.TestTaker;
import riasec.backend.model.enums.Gender;
import riasec.backend.model.enums.PersonalityType;
import riasec.backend.model.interfaces.TestAttempt;
import riasec.backend.repository.HollandCodeTestQuestionRepository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


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


    @PostMapping("/testAttempt")
    public ResponseEntity<Map<String, List<String>>> processAnswers(@RequestBody Map<Long, Boolean> answersJson) {
        Iterable<HollandCodeTestQuestion> questions = hollandCodeTestQuestionRepository.findAll();
        // Convert Map<Long, Boolean> to Map<HollandCodeTestQuestion, Boolean>
        Map<HollandCodeTestQuestion, Boolean> questionAnswers = new HashMap<>();
        for (HollandCodeTestQuestion question : questions) {
            Boolean answer = answersJson.get(question.getId());
            if (answer != null) {
                questionAnswers.put(question, answer);
            }
        }

        TestTaker testTaker = new TestTaker("Julia", "Zamaitat", "j.zamaitat@gmail.com", Gender.FEMALE);
        HollandCodeTestAttempt testAttempt = new HollandCodeTestAttempt();
        testAttempt.setTestTaker(testTaker);
        testAttempt.setQuestionAnswers(questionAnswers);

        // Apply Drools rules
        KieSession kieSession = createDroolsSession();
        kieSession.insert(testAttempt);
        kieSession.setGlobal("version", 2);
        kieSession.fireAllRules();



        System.out.println("Realistic Score: " + testAttempt.getScore(PersonalityType.REALISTIC));
        System.out.println("Artistic Score: " + testAttempt.getScore(PersonalityType.ARTISTIC));
        System.out.println("Investigative Score: " + testAttempt.getScore(PersonalityType.INVESTIGATIVE));
        System.out.println("Conventional Score: " + testAttempt.getScore(PersonalityType.CONVENTIONAL));
        System.out.println("Social Score: " + testAttempt.getScore(PersonalityType.SOCIAL));
        System.out.println("Enterprising Score: " + testAttempt.getScore(PersonalityType.ENTERPRISING));

        kieSession.dispose();

        Map<String, List<String>> response = new HashMap<>();

        response.put("text", testAttempt.getResult());

        return ResponseEntity.ok(response);
    }

    private KieSession createDroolsSession() {
        return kieContainer.newKieSession("rulesKSession");
    }
}
