package riasec.backend.model.classes;

import jakarta.persistence.*;
import riasec.backend.model.enums.PersonalityType;
import riasec.backend.model.interfaces.TestAttempt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Entity
public class HollandCodeTestAttempt implements TestAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "test_taker_id")
    private TestTaker testTaker;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

    private String result;
    @ManyToOne()
    @JoinColumn(name = "holland_code_test_id")
    private HollandCodeTest hollandCodeTest;
    private Integer realisticScore;
    private Integer investigativeScore;
    private Integer artisticScore;
    private Integer socialScore;
    private Integer enterprisingScore;
    private Integer conventionalScore;
    @ElementCollection
    @CollectionTable(name = "question_answers", joinColumns = @JoinColumn(name = "test_attempt_id"))
    @MapKeyJoinColumn(name = "question_id")
    @Column(name = "answer")
    private Map<HollandCodeTestQuestion, Boolean> questionAnswers;

    @Override
    public Integer getId() {
        return id;
    }

    public HollandCodeTestAttempt() {
    }

    public HollandCodeTestAttempt(TestTaker testTaker, String result, HollandCodeTest hollandCodeTest, Integer realisticScore, Integer investigativeScore, Integer artisticScore, Integer socialScore, Integer enterprisingScore, Integer conventionalScore, Map<HollandCodeTestQuestion, Boolean> questionAnswers) {
        this.testTaker = testTaker;
        this.result = result;
        this.hollandCodeTest = hollandCodeTest;
        this.realisticScore = realisticScore;
        this.investigativeScore = investigativeScore;
        this.artisticScore = artisticScore;
        this.socialScore = socialScore;
        this.enterprisingScore = enterprisingScore;
        this.conventionalScore = conventionalScore;
        this.questionAnswers = questionAnswers;
    }

    public TestTaker getTestTaker() {
        return testTaker;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public HollandCodeTest getTest() {
        return hollandCodeTest;
    }

    public Integer getScore(PersonalityType personalityType) {
        if (personalityType == null) {
            throw new IllegalArgumentException("PersonalityType cannot be null.");
        }
        switch (personalityType) {
            case REALISTIC:
                return realisticScore;
            case INVESTIGATIVE:
                return investigativeScore;
            case ARTISTIC:
                return artisticScore;
            case SOCIAL:
                return socialScore;
            case ENTERPRISING:
                return enterprisingScore;
            case CONVENTIONAL:
                return conventionalScore;
            default:
                throw new IllegalArgumentException("Invalid PersonalityType.");
        }
    }

    public Map<HollandCodeTestQuestion, Boolean> getQuestionAnswers() {
        return questionAnswers;
    }

}
