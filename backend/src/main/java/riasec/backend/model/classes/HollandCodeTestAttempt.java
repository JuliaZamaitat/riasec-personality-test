package riasec.backend.model.classes;

import jakarta.persistence.*;
import riasec.backend.model.enums.PersonalityType;
import riasec.backend.model.interfaces.TestAttempt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public class HollandCodeTestAttempt implements TestAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @ManyToOne()
    @JoinColumn(name = "test_taker_id")
    private TestTaker testTaker;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

    private List<String> result;
    @ManyToOne()
    @JoinColumn(name = "holland_code_test_id")
    private HollandCodeTest hollandCodeTest;
    private Integer realisticScore = 0;
    private Integer investigativeScore = 0;
    private Integer artisticScore = 0;
    private Integer socialScore = 0;
    private Integer enterprisingScore = 0;
    private Integer conventionalScore = 0;
    @ElementCollection
    @CollectionTable(name = "question_answers", joinColumns = @JoinColumn(name = "test_attempt_id"))
    @MapKeyJoinColumn(name = "question_id")
    @Column(name = "answer")
    private Map<HollandCodeTestQuestion, Boolean> questionAnswers;

    public HollandCodeTestAttempt() {
    }

    public HollandCodeTestAttempt(TestTaker testTaker, List<String> result, HollandCodeTest hollandCodeTest, Integer realisticScore, Integer investigativeScore, Integer artisticScore, Integer socialScore, Integer enterprisingScore, Integer conventionalScore, Map<HollandCodeTestQuestion, Boolean> questionAnswers) {
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


    @Override
    public Long getId() {
        return Id;
    }


    public void setTestTaker(TestTaker testTaker) {
        this.testTaker = testTaker;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public void setHollandCodeTest(HollandCodeTest hollandCodeTest) {
        this.hollandCodeTest = hollandCodeTest;
    }

    public void setQuestionAnswers(Map<HollandCodeTestQuestion, Boolean> questionAnswers) {
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
    public List<String> getResult() {
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

    public void incrementScore(PersonalityType personalityType) {
        if (personalityType == null) {
            throw new IllegalArgumentException("PersonalityType cannot be null.");
        }
//        System.out.println(personalityType);
        switch (personalityType) {
            case REALISTIC:
                this.realisticScore++;
                break;
            case INVESTIGATIVE:
                this.investigativeScore++;
                break;
            case ARTISTIC:
                this.artisticScore++;
                break;
            case SOCIAL:
                this.socialScore++;
                break;
            case ENTERPRISING:
                this.enterprisingScore++;
                break;
            case CONVENTIONAL:
                this.conventionalScore++;
                break;
            default:
                throw new IllegalArgumentException("Invalid PersonalityType.");
        }
    }

    public Map<HollandCodeTestQuestion, Boolean> getQuestionAnswers() {
        return questionAnswers;
    }

}
