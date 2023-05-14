package riasec.backend.model.classes;

import jakarta.persistence.*;
import riasec.backend.model.enums.PersonalityType;
import riasec.backend.model.interfaces.TestQuestion;

@Entity
public class HollandCodeTestQuestion implements TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String text;
    @Enumerated(EnumType.STRING)
    private PersonalityType personalityType;

    public HollandCodeTestQuestion() {}

    public HollandCodeTestQuestion(String text, PersonalityType personalityType) {
        this.text = text;
        this.personalityType = personalityType;
    }



    @Override
    public Long getId() {
        return Id;
    }
    @Override
    public String getText() {
        return text;
    }
    public PersonalityType getPersonalityType() {
        return personalityType;
    }
}
