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
        seedData.add(new HollandCodeTestQuestion("Are you mechanically inclined?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you stable?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you concrete?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you reserved?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you self-controlled?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you independent?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you ambitious?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you systematic?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you fix electrical things?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you solve electrical problems?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you pitch a tent?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you play a sport?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you read a blueprint?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you plant a garden?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you operate tools and machine?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to tinker with machines/vehicles?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to work outdoors?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to be physically active?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to be use your hands?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to build things?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to tend/train animals?", PersonalityType.REALISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to work on electronic equipment?", PersonalityType.REALISTIC));


        //Investigative
        seedData.add(new HollandCodeTestQuestion("Are you inquisitive?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Are you analytical?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Are you scientific?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Are you observant/precise?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Are you scholarly?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Are you cautious?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Are you intellectually self-confident?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Are you independent?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Are you logical?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Are you complex?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Are you curious?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Can you think abstractly?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Can you solve math problems?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Can you understand scientific theories?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Can you do complex calculations?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Can you use a microscope or computer?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Can you interpret formulas?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Do you like to explore a variety of ideas?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Do you like to work independently?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Do you like to perform lab experiments?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Do you like to deal with abstractions?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Do you like to do research?", PersonalityType.INVESTIGATIVE));
        seedData.add(new HollandCodeTestQuestion("Do you like to be challenged?", PersonalityType.INVESTIGATIVE));


        //Artistic
        seedData.add(new HollandCodeTestQuestion("Are you creative?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you imaginative?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you innovative?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you unconventional?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you emotional?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you independent?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you expressive?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you original?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you introspective?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you impulsive?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you sensitive?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you courageous?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you complicated?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you idealistic?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Are you nonconforming?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you sketch, draw, paint?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you play a musical instrument?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you write stories, poetry, music?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you sing, act, dance?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Can you design fashions or interiors?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to attend concerts, theatre, art exhibits?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to attend concerts, theatre, art exhibits?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to read fiction, plays, and poetry?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to work on crafts?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to take photography?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to express yourself creatively?", PersonalityType.ARTISTIC));
        seedData.add(new HollandCodeTestQuestion("Do you like to deal with ambiguous ideas?", PersonalityType.ARTISTIC));


        //Social
        seedData.add(new HollandCodeTestQuestion("Are you friendly?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Are you helpful?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Are you idealistic?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Are you insightful?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Are you outgoing?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Are you understanding?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Are you cooperative?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Are you generous?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Are you responsible?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Are you forgiving?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Are you patient?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Are you kind?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Can you teach/train others?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Can you express yourself clearly?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Can you teach/train others?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Can you lead a group discussion?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Can you mediate disputes?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Can you plan and supervise an activity?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Can you cooperate well with others?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to work in groups?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to help people with problems?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to do volunteer work?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to work with young people?", PersonalityType.SOCIAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to serve others?", PersonalityType.SOCIAL));


        //Enterprising
        seedData.add(new HollandCodeTestQuestion("Are you self-confident?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Are you assertive?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Are you persuasive?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Are you energetic?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Are you adventurous?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Are you ambitious?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Are you agreeable?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Are you talkative?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Are you extroverted?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Are you spontaneous?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Are you optimistic?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Can you initiate projects?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Can you convince people to do things your way?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Can you sell things?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Can you give talks or speeches?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Can you organize activities?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Can you lead a group?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Can you persuade others?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Do you like to make decisions?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Do you like to be elected to office?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Do you like to start your own business?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Do you like to campaign politically?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Do you like to meet important people?", PersonalityType.ENTERPRISING));
        seedData.add(new HollandCodeTestQuestion("Do you like to have power or status?", PersonalityType.ENTERPRISING));



        //Conventional
        seedData.add(new HollandCodeTestQuestion("Are you well-organized?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you accurate?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you numerically inclined?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you methodical?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you conscientious?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you efficient?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you conforming?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you practical?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you thrifty?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you systematic?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you structured?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you polite?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you ambitious?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you obedient?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Are you persistent?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Can you work well within a system?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Can you do a lot of paper work in a short time?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Can you keep accurate records?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Can you use a computer terminal?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Can you write effective business letters?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to follow clearly defined procedures?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to use data processing equipment?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to work with numbers?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to type or take shorthand?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to be responsible for details?", PersonalityType.CONVENTIONAL));
        seedData.add(new HollandCodeTestQuestion("Do you like to collect or organize things?", PersonalityType.CONVENTIONAL));


        for (HollandCodeTestQuestion q: seedData) {
            hollandCodeTestQuestionRepository.save(q);
        }


        List<HollandCodeTestQuestion> subSet = new ArrayList<>();
        for (int i = 0; i < seedData.size(); i++) {
            if ((i + 1) % 10 == 0) { // Check if it's the 10th question
                subSet.add(seedData.get(i)); // Add the question to the new list
            }
        }
        HollandCodeTest testDemonstration = new HollandCodeTest("Holland Code Test (Demo)", "This is a personality test based on the RIASEC model. This test is for demonstration purposes only, with a limited amount of questions.", 1, subSet);
        HollandCodeTest fullTest = new HollandCodeTest("Holland Code Test", "This is a personality test based on the RIASEC model. This is a full version of the test, including every question.", 1, seedData);
        hollandCodeTestRepository.save(testDemonstration);
        hollandCodeTestRepository.save(fullTest);

    }
}
