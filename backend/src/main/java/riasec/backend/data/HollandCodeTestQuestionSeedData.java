package riasec.backend.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import riasec.backend.model.classes.HollandCodeTest;
import riasec.backend.model.classes.HollandCodeTestQuestion;
import riasec.backend.model.enums.PersonalityType;
import riasec.backend.repository.HollandCodeTestQuestionRepository;
import riasec.backend.repository.HollandCodeTestRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class HollandCodeTestQuestionSeedData implements CommandLineRunner {
    @Autowired
    HollandCodeTestQuestionRepository hollandCodeTestQuestionRepository;

    @Autowired
    HollandCodeTestRepository hollandCodeTestRepository;


    @Override
    public void run(String... args) throws Exception {
        List<HollandCodeTestQuestion> seedData = new ArrayList<>();



        //Realistic
        seedData.add(new HollandCodeTestQuestion("Are you practical?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you straightforward/frank?", PersonalityType.REALISTIC));
//        seedData.add(new HollandCodeTestQuestion("Are you mechanically inclined?", PersonalityType.REALISTIC));
//        seedData.add(new HollandCodeTestQuestion("Are you stable?", PersonalityType.REALISTIC));
//        seedData.add(new HollandCodeTestQuestion("Are you concrete?", PersonalityType.REALISTIC));
//        seedData.add(new HollandCodeTestQuestion("Are you reserved?", PersonalityType.REALISTIC));
//        seedData.add(new HollandCodeTestQuestion("Are you self-controlled?", PersonalityType.REALISTIC));
//        seedData.add(new HollandCodeTestQuestion("Are you independent?", PersonalityType.REALISTIC));
//        seedData.add(new HollandCodeTestQuestion("Are you ambitious?", PersonalityType.REALISTIC));
//        seedData.add(new HollandCodeTestQuestion("Are you systematic?", PersonalityType.REALISTIC));

        seedData.add(new HollandCodeTestQuestion("Can you fix electrical things?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you solve electrical problems?", PersonalityType.REALISTIC));
//        seedData.add(new HollandCodeTestQuestion("Can you pitch a tent?", PersonalityType.REALISTIC));
        //...
        seedData.add(new HollandCodeTestQuestion("Do you like to tinker with machines/vehicles?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to work outdoors?", PersonalityType.REALISTIC));
//        ...


        //Investigative
        seedData.add(new HollandCodeTestQuestion("Are you inquisitive?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Are you analytical?", PersonalityType.INVESTIGATIVE));
        //...
        seedData.add(new HollandCodeTestQuestion("Can you think abstractly?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Can you solve math problems?", PersonalityType.INVESTIGATIVE));
//        ...
        seedData.add(new HollandCodeTestQuestion("Do you like to explore a variety of ideas?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Can you like to work independently?", PersonalityType.INVESTIGATIVE));


        //Artistic
        seedData.add(new HollandCodeTestQuestion("Are you creative?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you imaginative?", PersonalityType.ARTISTIC));
//        ...
        seedData.add(new HollandCodeTestQuestion("Can you sketch, draw, paint?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you play a musical instrument?", PersonalityType.ARTISTIC));
//        ...
        seedData.add(new HollandCodeTestQuestion("Do you like to attend concerts, theatre, art exhibits?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to read fiction, plays, and poetry", PersonalityType.ARTISTIC));


        //Social
        seedData.add(new HollandCodeTestQuestion("Are you friendly?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Are you helpful?", PersonalityType.SOCIAL));
//        ...
        seedData.add(new HollandCodeTestQuestion("Can you teach/train others?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Can you express yourself clearly?", PersonalityType.SOCIAL));
//        ...
        seedData.add(new HollandCodeTestQuestion("Do you like to work in groups?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to help people with problems?", PersonalityType.SOCIAL));
//        ...


        //Enterprising
        seedData.add(new HollandCodeTestQuestion("Are you self-confident?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Are you assertive?", PersonalityType.ENTERPRISING));
//        ...
        seedData.add(new HollandCodeTestQuestion("Can you initiate projects?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Can you convince people to do things your way", PersonalityType.ENTERPRISING));
//        ...
        seedData.add(new HollandCodeTestQuestion("Do you like to make decisions?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Do you like to be elected to office?", PersonalityType.ENTERPRISING));


        //Conventional
        seedData.add(new HollandCodeTestQuestion("Are you well-organized?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you accurate?", PersonalityType.CONVENTIONAL));
//        ...
        seedData.add(new HollandCodeTestQuestion("Can you work well within a system?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Can you do a lot of paper work in a short time?", PersonalityType.CONVENTIONAL));
//        ...
        seedData.add(new HollandCodeTestQuestion("Do you like to follow clearly defined procedures?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to use data processing equipment?", PersonalityType.CONVENTIONAL));


        for (HollandCodeTestQuestion q: seedData) {
            hollandCodeTestQuestionRepository.save(q);
        }

        HollandCodeTest test = new HollandCodeTest("Holland Code Test", "This is a personality test based on the RIASEC model. This is a first basic implementation.", 1, seedData);
        hollandCodeTestRepository.save(test);
    }
}
