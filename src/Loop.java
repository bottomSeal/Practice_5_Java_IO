import java.util.ArrayList;
import java.util.Scanner;

public class Loop {
    private static ArrayList<Task> allTask = new ArrayList<>();
    private static ArrayList<Task> completedTasks = new ArrayList<>();
    private static ArrayList<Employer> employers = new ArrayList<>();

    public static void start() {
        GenerateLogic.generateTask(10);
        GenerateLogic.generateEmployers(5);
        new MainMenu(new Scanner(System.in)).startMenu();
    }

    public static void addTask(Task task) {
        allTask.add(task);
    }

    public static void addCompletedTask(Task task) {
        completedTasks.add(task);
    }

    public static void addEmployer(Employer employer) {
        employers.add(employer);
    }

    public static ArrayList<Task> getAllTask() {
        return allTask;
    }

    public static ArrayList<Employer> getEmployers() {
        return employers;
    }

    public static ArrayList<Task> getCompletedTasks() {
        return completedTasks;
    }
}
