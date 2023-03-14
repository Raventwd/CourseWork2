package Task;

import Exceptions.IncorrectArgumentException;

import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeatability {
    public WeeklyTask(String title, String description, TaskType taskType, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description , taskType, dateTime);
    }

    @Override
    public boolean checkOccurance(LocalDateTime requestedDate) {
        return getDateTime().getDayOfWeek()== (requestedDate.getDayOfWeek());
    }
}