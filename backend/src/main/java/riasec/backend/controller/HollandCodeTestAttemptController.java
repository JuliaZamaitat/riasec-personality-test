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
import riasec.backend.model.classes.Profession;
import riasec.backend.model.classes.TestTaker;
import riasec.backend.model.enums.Gender;
import riasec.backend.model.enums.PersonalityType;
import riasec.backend.model.interfaces.TestAttempt;
import riasec.backend.repository.HollandCodeTestQuestionRepository;
import riasec.backend.repository.ProfessionRepository;

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

    @PostMapping("/testAttempt")
    public ResponseEntity<Map<String, List<?>>> processAnswers(@RequestBody Map<Long, Boolean> answersJson) {

        //Prepare Data
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


        System.out.println("Realistic Score: " + testAttempt.getScore(PersonalityType.REALISTIC));
        System.out.println("Artistic Score: " + testAttempt.getScore(PersonalityType.ARTISTIC));
        System.out.println("Investigative Score: " + testAttempt.getScore(PersonalityType.INVESTIGATIVE));
        System.out.println("Conventional Score: " + testAttempt.getScore(PersonalityType.CONVENTIONAL));
        System.out.println("Social Score: " + testAttempt.getScore(PersonalityType.SOCIAL));
        System.out.println("Enterprising Score: " + testAttempt.getScore(PersonalityType.ENTERPRISING));
        System.out.println("Exact Matches" + exactMatches.toString());
        System.out.println("Similar Matches" + similarMatches.toString());

        //Disposing Session
        kieSession.dispose();


        //Sending Response to Frontend
        Map<String, List<?>> response = new HashMap<>();
        response.put("hollandCode", testAttempt.getResult());
        response.put("exactProfessions", exactMatches);
        response.put("similarProfessions", similarMatches);

        return ResponseEntity.ok(response);
    }

    private KieSession createDroolsSession() {
        return kieContainer.newKieSession("rulesKSession");
    }
}
