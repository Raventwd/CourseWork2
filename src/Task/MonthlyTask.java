package Task;

import Exceptions.IncorrectArgumentException;

import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repeatability {
    public MonthlyTask(String title, String description, TaskType taskType, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description , taskType, dateTime);
    }

    @Override
    public boolean checkOccurance(LocalDateTime requestedDate) {
        return getDateTime().getDayOfMonth()== (requestedDate.getDayOfMonth());
    }
}