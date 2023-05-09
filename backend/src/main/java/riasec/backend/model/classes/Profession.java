package riasec.backend.model.classes;

import jakarta.persistence.*;
import riasec.backend.model.enums.PersonalityType;

import java.util.List;

@Entity
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    @ElementCollection
    @CollectionTable(name = "personality_types", joinColumns = @JoinColumn(name = "profession_id"))
    @Enumerated(EnumType.STRING)
    private List<PersonalityType> personalityType;

    public Profession() {}

    public Profession(String title, List<PersonalityType> personalityType) {
        this.title = title;
        this.personalityType = personalityType;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<PersonalityType> getPersonalityType() {
        return personalityType;
    }
}
