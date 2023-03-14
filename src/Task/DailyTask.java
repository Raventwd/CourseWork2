package Task;

import Exceptions.IncorrectArgumentException;

import java.time.LocalDateTime;

public class DailyTask extends Task implements Repeatability {
    public DailyTask(String title, String description, TaskType taskType, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description , taskType, dateTime);
    }

    @Override
    public boolean checkOccurance(LocalDateTime requestedDate) {
        return getDateTime().toLocalDate().equals(requestedDate.toLocalDate());
    }
}
