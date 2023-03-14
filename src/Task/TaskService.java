package Task;

import Exceptions.IncorrectArgumentException;
import Exceptions.TaskNotFoundException;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TaskService {
    private static final Map<Integer, Repeatability> taskMap = new HashMap<>();
    private static final Map<Integer, Repeatability> deletedTasks = new HashMap<>();

    public static void addTask(Scanner scanner) {
        try {
            scanner.nextLine();
            System.out.println("Введите название задачи");
            String title = Check.checkString(scanner.nextLine());
            System.out.println("Введите описание задачи");
            String description = Check.checkString(scanner.nextLine());
            System.out.println("Введите тип задачи");
            TaskType taskType = TaskType.values()[scanner.nextInt()];
            System.out.println("Введите повторяемость задачи: 0 - Однократная, 1 - Ежедневная, 2 - Еженедельная, 3 - Ежемесячная, 4 - Ежегодная ");
            int occurance = scanner.nextInt();
            System.out.println("Введите дату формата dd.mm.yyyy hh.mm");
            scanner.nextLine();
            System.out.println("Для выхода нажмите Enter/n");
            scanner.nextLine();
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Repeatability createTask(int occurance, String title, String description, TaskType taskType, LocalDateTime dateTime) throws IncorrectArgumentException {
        switch (occurance) {
            case 0: {
                OneTimeTask task = new OneTimeTask(title, description, taskType, dateTime);
                taskMap.put(task.getId(), task);
            }
            case 1: {
                DailyTask task = new DailyTask(title, description, taskType, dateTime);
                taskMap.put(task.getId(), task);
            }
            case 2: {
                WeeklyTask task = new WeeklyTask(title, description, taskType, dateTime);
                taskMap.put(task.getId(), task);
            }
            case 3: {
                MonthlyTask task = new MonthlyTask(title, description, taskType, dateTime);
                taskMap.put(task.getId(), task);
            }
            case 4: {
                YearlyTask task = new YearlyTask(title, description, taskType, dateTime);
                taskMap.put(task.getId(), task);
            }

        }
        return null;
    }

    public static void deleteTask(Scanner scanner) throws TaskNotFoundException {
        System.out.println("Введите id задачи");
        int id = scanner.nextInt();
        if (taskMap.containsKey(id)) {
            taskMap.remove(id);
            System.out.println("Задача " + id + " удалена");
        } else {
            throw new TaskNotFoundException("Задачи с таким id не существует");
        }
    }

    public static void getTasksByDay(Scanner scanner) {
        System.out.println("Введите дату в формате dd.mm.yyyy hh.mm");
        try {
            String date = scanner.next();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate requestedDate = LocalDate.parse(date, dateFormatter);
            List<Repeatability> foundEvents = findTasksByDay(requestedDate);
            System.out.println("Событие на " + requestedDate);
            for (Repeatability task : foundEvents){
                System.out.println(task);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Введите дату в формате dd.mm.yyyy hh.mm");
        }
    }

    private static List<Repeatability> findTasksByDay(LocalDate date) {
        List<Repeatability> tasks = new ArrayList<>();
        for (Repeatability task : taskMap.values()) {
            if (task.checkOccurance(date.atStartOfDay())) {
                tasks.add(task);
            }
        }
        return tasks;
    }
}