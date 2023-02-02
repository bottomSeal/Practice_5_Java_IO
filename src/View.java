import java.util.ArrayList;

public class View {
    public static void printEmployers(ArrayList<Employer> employers) {
        for (Employer employer: employers) {
            employer.printInfo();
        }
    }

    public static void printTasks(ArrayList<Task> tasks) {
        for (Task task: tasks) {
            task.printInfo();
        }
    }
}
