package riasec.backend.model.classes;

import jakarta.persistence.*;
@Entity
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String title;
    private String hollandCode;

    public Profession() {}

    public Profession(String title, String hollandCode) {
        this.title = title;
        this.hollandCode = hollandCode;
    }

    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getHollandCode() { return hollandCode;}

}
