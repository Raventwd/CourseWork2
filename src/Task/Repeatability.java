package Task;

import java.time.LocalDateTime;

public interface Repeatability {

    boolean checkOccurance(LocalDateTime dateTime);

    void setTitle(String title);

    LocalDateTime getDateTime();
}
