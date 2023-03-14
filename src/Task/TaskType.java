package Task;

public enum TaskType {
    Work(0),
    Personal(1);

    public final int value;
    TaskType(final int value){this.value = value;}
}
