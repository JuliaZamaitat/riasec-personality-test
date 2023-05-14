package riasec.backend.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import riasec.backend.model.interfaces.Test;

import java.util.List;

@Entity
public class HollandCodeTest implements Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    private String description;
    private Integer version;

    public HollandCodeTest() {}

    public HollandCodeTest(String title, String description, Integer version, List<HollandCodeTestQuestion> hollandCodeTestQuestions) {
        this.title = title;
        this.description = description;
        this.version = version;
        this.hollandCodeTestQuestions = hollandCodeTestQuestions;
    }

    @ManyToMany
    @JoinTable(
        name = "holland_code_test_questions",
        joinColumns = @JoinColumn(name = "holland_code_test_id"),
        inverseJoinColumns = @JoinColumn(name = "holland_code_test_question_id")
    )
    private List<HollandCodeTestQuestion> hollandCodeTestQuestions;



    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    public List<HollandCodeTestQuestion> getTestQuestions() {
        return hollandCodeTestQuestions;
    }
}
