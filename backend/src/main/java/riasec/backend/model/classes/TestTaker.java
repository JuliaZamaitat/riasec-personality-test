package riasec.backend.model.classes;

import jakarta.persistence.*;
import riasec.backend.model.enums.Gender;

import java.util.List;

@Entity
public class TestTaker {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "testTaker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HollandCodeTestAttempt> testAttempts;

    public TestTaker() {}
    public TestTaker(String firstName, String lastName, String emailAddress, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<HollandCodeTestAttempt> getTestAttempts() {
        return testAttempts;
    }

    public void setTestAttempts(List<HollandCodeTestAttempt> testAttempts) {
        this.testAttempts = testAttempts;
    }


}
