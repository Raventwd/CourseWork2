package Task;

import Exceptions.IncorrectArgumentException;

import java.time.LocalDateTime;

public abstract class Task {
    private int idGenerator;
    private String title;
    private final int id;
    private TaskType taskType;
    private LocalDateTime dateTime;
    private String description;

    private static int counter = 1;


    public Task(String title, String description,TaskType taskType, LocalDateTime dateTime) throws IncorrectArgumentException {
        this.title = Check.checkString(title);
        this.description = Check.checkString(description);
    this.taskType=taskType;
        id = counter++;
        this.dateTime = dateTime;
    }


    public int getId() {
        return id;
    }

    public TaskType getType() {
        return taskType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "idGenerator=" + idGenerator +
                ", title='" + title + '\'' +
                ", id=" + id +
                ", taskType=" + taskType +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
