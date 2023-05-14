package riasec.backend.model.interfaces;

import java.util.Date;

public interface TestAttempt {
    Long getId();
    Date getDate();
    Object getResult();
    Test getTest();
}
