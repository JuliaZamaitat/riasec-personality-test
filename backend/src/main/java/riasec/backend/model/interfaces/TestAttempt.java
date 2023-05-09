package riasec.backend.model.interfaces;

import riasec.backend.model.interfaces.Test;

import java.util.Date;

public interface TestAttempt {
    Integer getId();
    Date getDate();
    Object getResult();
    Test getTest();
}
